package com.fajar.quranapp.core.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fajar.quranapp.R
import com.fajar.quranapp.core.data.local.entity.QuranEntity
import com.fajar.quranapp.core.domain.model.Quran
import com.fajar.quranapp.core.util.MyDiffUtil
import com.fajar.quranapp.databinding.SurahItemBinding

import java.util.ArrayList

class AyahAdapter : RecyclerView.Adapter<AyahAdapter.ListViewHolder>() {

    private var listSurah = ArrayList<Quran>()
    var onItemClick: ((Quran) -> Unit)? = null


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SurahItemBinding.bind(itemView)
        fun bind(data: Quran) {
            with(binding) {
                tvSurahEN.text = data.englishName
                tvRevelation.text = data.revelationType
                tvAyah.text = data.numberOfAyahs.toString()
                tvNameArab.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listSurah[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.surah_item, parent, false))

    override fun getItemCount(): Int = if (listSurah.size <= 10) listSurah.size else 10

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = listSurah[position]
        holder.bind(movie)
    }

    fun setData(newMovieList: List<Quran>){
        val diffUtil = SurahDiffUtil(listSurah,newMovieList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        this.listSurah.clear()
        this.listSurah.addAll(newMovieList)
        diffResults.dispatchUpdatesTo(this)
    }
}