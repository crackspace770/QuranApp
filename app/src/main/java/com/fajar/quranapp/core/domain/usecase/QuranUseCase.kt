package com.fajar.quranapp.core.domain.usecase

import com.fajar.quranapp.core.data.Resource
import com.fajar.quranapp.core.domain.model.Quran
import kotlinx.coroutines.flow.Flow

interface QuranUseCase {

    fun getAllSurah(): Flow<Resource<List<Quran>>>
    fun getFavoriteSurah(): Flow<List<Quran>>
    fun setFavoriteSurah(quran: Quran, state: Boolean)
}