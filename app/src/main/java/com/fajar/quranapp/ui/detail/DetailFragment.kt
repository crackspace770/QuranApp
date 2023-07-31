package com.fajar.quranapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fajar.quranapp.core.adapter.AyahAdapter
import com.fajar.quranapp.core.data.Resource
import com.fajar.quranapp.core.ui.ViewModelFactory
import com.fajar.quranapp.databinding.FragmentListSurahBinding
import com.fajar.quranapp.ui.surah.ListSurahViewModel

class DetailFragment: Fragment() {

    private lateinit var viewModel: ListSurahViewModel
    private var _binding : FragmentListSurahBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListSurahBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this,factory)[ListSurahViewModel::class.java]

        val ayahAdapter = AyahAdapter()
        ayahAdapter.onItemClick

        with(binding.rvSurah){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = ayahAdapter
        }

        viewModel.surah.observe(viewLifecycleOwner){ dataSurah->
            if (dataSurah!=null){
                when(dataSurah){
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        dataSurah.data?.let { ayahAdapter.setData(it) }
                    }

                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        // binding.viewError.root.visibility = View.VISIBLE
                        //  binding.viewError.tvError.text =
                        //      surah.message ?: getString(R.string.something_wrong)
                    }
                }

            }
        }


    }

}