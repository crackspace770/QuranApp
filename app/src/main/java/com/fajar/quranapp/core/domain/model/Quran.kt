package com.fajar.quranapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quran(
    val number: Int,
    val englishName: String,
    val numberOfAyahs: Int,
    val revelationType: String,
    val name: String,
    val englishNameTranslation: String,
    var isBookmarked: Boolean = false
): Parcelable