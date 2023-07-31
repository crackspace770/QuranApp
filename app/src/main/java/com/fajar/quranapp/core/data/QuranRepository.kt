package com.fajar.quranapp.core.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.fajar.quranapp.core.data.local.LocalDataSource
import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.data.local.room.QuranDao
import com.fajar.quranapp.core.data.local.room.QuranDatabase
import com.fajar.quranapp.core.data.remote.RemoteDataSource
import com.fajar.quranapp.core.data.remote.network.ApiResponse
import com.fajar.quranapp.core.data.remote.response.SurahResponse
import com.fajar.quranapp.core.domain.model.Quran
import com.fajar.quranapp.core.domain.repository.IQuranRepository
import com.fajar.quranapp.core.util.AppExecutors
import com.fajar.quranapp.core.util.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.ExecutorService

class QuranRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IQuranRepository{


    companion object {
        @Volatile
        private var instance: QuranRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): QuranRepository =
            instance ?: synchronized(this) {
                instance ?: QuranRepository(remoteData, localData, appExecutors)
            }
    }

   override fun getAllSurah(): Flow<Resource<List<Quran>>> =
        object : NetworkBoundResource<List<Quran>, List<SurahResponse>>() {
            override fun loadFromDB(): Flow<List<Quran>> {
                return localDataSource.getAllQuran().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Quran>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<SurahResponse>>> =
                remoteDataSource.getAllQuran()

            override suspend fun saveCallResult(data: List<SurahResponse>) {
                val surahList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSurah(surahList)
            }
        }.asFlow()

    override fun getFavoriteSurah(): Flow<List<Quran>> {
        return localDataSource.getFavoriteSurah().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteSurah(tourism: Quran, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}