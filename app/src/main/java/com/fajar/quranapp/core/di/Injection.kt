package com.fajar.quranapp.core.di

import android.content.Context
import com.fajar.quranapp.core.data.QuranRepository
import com.fajar.quranapp.core.data.local.LocalDataSource
import com.fajar.quranapp.core.data.local.room.QuranDatabase
import com.fajar.quranapp.core.data.remote.RemoteDataSource
import com.fajar.quranapp.core.data.remote.network.ApiConfig
import com.fajar.quranapp.core.domain.repository.IQuranRepository
import com.fajar.quranapp.core.domain.usecase.QuranInteractor
import com.fajar.quranapp.core.domain.usecase.QuranUseCase
import com.fajar.quranapp.core.util.AppExecutors
import com.fajar.quranapp.core.util.JsonHelper

object Injection {
    fun provideRepository(context: Context): IQuranRepository {
        val database = QuranDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.quranDao())
        val appExecutors = AppExecutors()

        return QuranRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideQuranUseCase(context: Context): QuranUseCase {
        val repository = provideRepository(context)
        return QuranInteractor(repository)
    }
}