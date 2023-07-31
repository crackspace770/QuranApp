package com.fajar.quranapp.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fajar.quranapp.core.data.QuranRepository
import com.fajar.quranapp.core.domain.usecase.QuranUseCase

class BookmarkViewModel (quranUseCase: QuranUseCase): ViewModel() {

    val favoriteSurah = quranUseCase.getFavoriteSurah().asLiveData()

}