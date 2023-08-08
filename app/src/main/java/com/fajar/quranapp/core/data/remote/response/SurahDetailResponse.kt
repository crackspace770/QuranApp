package com.fajar.quranapp.core.data.remote.response

import com.fajar.quranapp.core.domain.model.Verse
import com.google.gson.annotations.SerializedName

data class SurahDetailResponse(

    @SerializedName("englishName") var name: String?,
    @SerializedName("name") var arabicName: String?,
    @SerializedName("numberOfAyahs") var verseNum: Int?,
    @SerializedName("revelationType") var type: String?,
    @SerializedName("ayahs") var verses: List<Verse?>?

)
