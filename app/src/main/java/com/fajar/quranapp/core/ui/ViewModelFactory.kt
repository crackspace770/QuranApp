package com.fajar.quranapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fajar.quranapp.core.data.QuranRepository
import com.fajar.quranapp.core.di.Injection
import com.fajar.quranapp.core.domain.usecase.QuranUseCase
import com.fajar.quranapp.ui.bookmark.BookmarkViewModel
import com.fajar.quranapp.ui.surah.ListSurahViewModel

class ViewModelFactory private constructor(private val quranUseCase: QuranUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideQuranUseCase(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(ListSurahViewModel::class.java) -> {
                ListSurahViewModel(quranUseCase) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(quranUseCase) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}