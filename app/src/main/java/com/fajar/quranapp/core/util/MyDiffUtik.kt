package com.fajar.quranapp.core.util

import androidx.recyclerview.widget.DiffUtil
import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.domain.model.Quran

class MyDiffUtil(
    private val oldList: List<Quran>,
    private val newList: List<Quran>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}