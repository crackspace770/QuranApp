package com.fajar.quranapp.core.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fajar.quranapp.core.domain.model.Quran

class SurahDiffUtil (
    private val oldList: List<Quran>,
    private val newList: List<Quran>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].number == newList[newItemPosition].number
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]



}