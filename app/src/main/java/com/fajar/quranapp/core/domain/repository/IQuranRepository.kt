package com.fajar.quranapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.fajar.quranapp.core.data.Resource
import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.domain.model.Quran
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {

    fun getAllSurah(): Flow<Resource<List<Quran>>>

    fun getFavoriteSurah(): Flow<List<Quran>>

    fun setFavoriteSurah(tourism: Quran, state: Boolean)

}