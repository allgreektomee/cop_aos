package com.devcation.agtm.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.devcation.agtm.R
import com.devcation.agtm.common.RecyclerViewDecoration
import com.devcation.agtm.databinding.FragmentMainBinding
import com.devcation.agtm.view.adapter.WineListVPAdapter


class MainFragment : Fragment() {
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var list = mutableListOf(R.drawable.wine, R.drawable.wine, R.drawable.wine, R.drawable.wine)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val selectedRVAdapter = WineListVPAdapter(requireContext(), list)
        binding.wineListRecycler.adapter = selectedRVAdapter
        binding.wineListRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.wineListRecycler.addItemDecoration(RecyclerViewDecoration(20))
        

        binding.wineListRecycler2.adapter = selectedRVAdapter
        binding.wineListRecycler2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.wineListRecycler2.addItemDecoration(RecyclerViewDecoration(20))


        binding.wineListRecycler3.adapter = selectedRVAdapter
        binding.wineListRecycler3.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.wineListRecycler3.addItemDecoration(RecyclerViewDecoration(20))



    }
}