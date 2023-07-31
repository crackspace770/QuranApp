package com.fajar.quranapp.core.domain.usecase

import com.fajar.quranapp.core.domain.model.Quran
import com.fajar.quranapp.core.domain.repository.IQuranRepository

class QuranInteractor(private val quranRepository: IQuranRepository): QuranUseCase {

    override fun getAllSurah() = quranRepository.getAllSurah()

    override fun getFavoriteSurah() = quranRepository.getFavoriteSurah()

    override fun setFavoriteSurah(quran: Quran, state: Boolean) = quranRepository.setFavoriteSurah(quran, state)

}