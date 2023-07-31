package com.fajar.quranapp.ui.bookmark

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fajar.quranapp.core.adapter.AyahAdapter
import com.fajar.quranapp.core.ui.ViewModelFactory
import com.fajar.quranapp.databinding.FragmentBookmarkBinding

class BookmarkFragment : Fragment() {

    private  lateinit var bookmarkViewModel: BookmarkViewModel
    private  var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val tourismAdapter = AyahAdapter()
            tourismAdapter.onItemClick = { selectedData ->
             //   val intent = Intent(activity, DetailTourismActivity::class.java)
            //    intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
            //    startActivity(intent)
            }

            val factory = ViewModelFactory.getInstance(requireActivity())
            bookmarkViewModel= ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

            bookmarkViewModel.favoriteSurah.observe(viewLifecycleOwner) { dataTourism ->
                tourismAdapter.setData(dataTourism)
                binding.viewError.root.visibility =
                    if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvSurah) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }

    }

}