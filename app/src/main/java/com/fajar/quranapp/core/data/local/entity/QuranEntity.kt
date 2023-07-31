package com.fajar.quranapp.core.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "quran")
data class QuranEntity(

    @PrimaryKey
    @ColumnInfo(name = "number")
    val number: Int,

    @ColumnInfo(name = "englishName")
    val englishName: String,

    @ColumnInfo(name = "numberOfAyahs")
    val numberOfAyahs: Int,

    @ColumnInfo(name = "revelationType")
    val revelationType: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "englishNameTranslation")
    val englishNameTranslation: String,

    @ColumnInfo(name = "isBookmarked")
    var isBookmarked: Boolean = false
)