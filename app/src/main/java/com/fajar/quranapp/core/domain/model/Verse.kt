package com.fajar.quranapp.core.domain.model

import com.google.gson.annotations.SerializedName

class Verse (
    var audio: String?,
    var text: String?,
    @SerializedName("numberInSurah") var verseNumber: Int?
        )