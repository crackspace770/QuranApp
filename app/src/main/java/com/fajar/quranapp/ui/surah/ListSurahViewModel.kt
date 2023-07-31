package com.fajar.quranapp.ui.surah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fajar.quranapp.core.data.QuranRepository
import com.fajar.quranapp.core.domain.usecase.QuranUseCase

class ListSurahViewModel (quranUseCase: QuranUseCase) :ViewModel() {

    val surah = quranUseCase.getAllSurah().asLiveData()

}