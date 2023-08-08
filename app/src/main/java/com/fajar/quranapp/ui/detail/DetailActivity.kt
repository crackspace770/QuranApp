package com.fajar.quranapp.ui.detail

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.fajar.quranapp.databinding.FragmentListSurahBinding
import com.fajar.quranapp.ui.surah.ListSurahViewModel

class DetailActivity:AppCompatActivity() {

    private lateinit var viewModel: ListSurahViewModel
    private lateinit var binding: FragmentListSurahBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = FragmentListSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}