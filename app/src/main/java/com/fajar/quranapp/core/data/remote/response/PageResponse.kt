package com.fajar.quranapp.core.data.remote.response

data class PageResponse(
	val code: Int,
	val data: Data,
	val status: String
)

data class JsonMember1(
	val number: Int,
	val englishName: String,
	val numberOfAyahs: Int,
	val revelationType: String,
	val name: String,
	val englishNameTranslation: String
)

data class Surah(
	val number: Int,
	val englishName: String,
	val numberOfAyahs: Int,
	val revelationType: String,
	val name: String,
	val englishNameTranslation: String
)

data class Data(
	val number: Int,
	val edition: Edition,
	val ayahs: List<AyahsItem>,
	val surahs: Surahs
)

data class Edition(
	val identifier: String,
	val englishName: String,
	val name: String,
	val format: String,
	val language: String,
	val type: String,
	val direction: String
)

data class AyahsItem(
	val number: Int,
	val hizbQuarter: Int,
	val ruku: Int,
	val manzil: Int,
	val text: String,
	val page: Int,
	val sajda: Boolean,
	val surah: Surah,
	val numberInSurah: Int,
	val juz: Int
)

data class Surahs(
	val jsonMember1: JsonMember1
)

