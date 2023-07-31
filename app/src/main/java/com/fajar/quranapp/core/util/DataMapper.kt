package com.fajar.quranapp.core.util

import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.data.remote.response.SurahResponse
import com.fajar.quranapp.core.domain.model.Quran

object DataMapper {
    fun mapResponsesToEntities(input: List<SurahResponse>): List<QuranEntity> {
        val tourismList = ArrayList<QuranEntity>()
        input.map {
            val tourism = QuranEntity(
                number = it.number,
                englishName = it.englishName,
                numberOfAyahs = it.numberOfAyahs,
                revelationType = it.revelationType,
                name = it.name,
                englishNameTranslation = it.englishNameTranslation,
                isBookmarked = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<QuranEntity>): List<Quran> =
        input.map {
            Quran(
                number = it.number,
                englishName = it.englishName,
                numberOfAyahs = it.numberOfAyahs,
                revelationType = it.revelationType,
                name = it.name,
                englishNameTranslation = it.englishNameTranslation,
                isBookmarked = false
            )
        }
    fun mapDomainToEntity(input: Quran) = QuranEntity(
        number = input.number,
        englishName = input.englishName,
        numberOfAyahs = input.numberOfAyahs,
        revelationType = input.revelationType,
        name = input.name,
        englishNameTranslation = input.englishNameTranslation,
        isBookmarked = false
    )
}