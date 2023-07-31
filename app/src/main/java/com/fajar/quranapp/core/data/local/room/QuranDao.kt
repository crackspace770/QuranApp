package com.fajar.quranapp.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.fajar.quranapp.core.data.local.entity.QuranEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranDao {

    @Query("SELECT * FROM quran")
    fun getAllSurah(): Flow<List<QuranEntity>>

    @Query("SELECT * FROM quran where isBookmarked = 1")
    fun getFavoriteSurah(): Flow<List<QuranEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurah(quran: List<QuranEntity>)

    @Update
    fun updateFavoriteSurah(quran: QuranEntity)
}

