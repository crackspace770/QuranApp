package com.fajar.quranapp.core.adapter

import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.domain.model.Quran

interface ItemClickCallback {
    fun onItemClicked(quranItem: Quran)
}