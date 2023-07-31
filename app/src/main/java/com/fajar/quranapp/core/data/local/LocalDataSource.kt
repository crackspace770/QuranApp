package com.fajar.quranapp.core.data.local

import androidx.lifecycle.LiveData
import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.data.local.room.QuranDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val tourismDao: QuranDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: QuranDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    fun getAllQuran(): Flow<List<QuranEntity>> = tourismDao.getAllSurah()

    fun getFavoriteSurah(): Flow<List<QuranEntity>> = tourismDao.getFavoriteSurah()

    suspend fun insertSurah(tourismList: List<QuranEntity>) = tourismDao.insertSurah(tourismList)

    fun setFavoriteTourism(tourism: QuranEntity, newState: Boolean) {
        tourism.isBookmarked = newState
        tourismDao.updateFavoriteSurah(tourism)
    }
}