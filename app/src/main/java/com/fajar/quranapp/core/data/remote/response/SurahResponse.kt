package com.fajar.quranapp.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListSurahResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("places")
	val list: List<SurahResponse>
)

data class SurahResponse(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("englishName")
	val englishName: String,

	@field:SerializedName("numberOfAyahs")
	val numberOfAyahs: Int,

	@field:SerializedName("revelationType")
	val revelationType: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("englishNameTranslation")
	val englishNameTranslation: String
)
