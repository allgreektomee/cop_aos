package com.devcation.agtm.view.like

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.devcation.agtm.R
import com.devcation.agtm.common.RecyclerViewDecoration
import com.devcation.agtm.databinding.FragmentLikeBinding
import com.devcation.agtm.databinding.FragmentMainBinding
import com.devcation.agtm.view.adapter.WineListVPAdapter
import com.devcation.agtm.view.main.WineDetailActivity
import com.devcation.agtm.viewModel.MainViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LikeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LikeFragment : Fragment() {

    private var _binding : FragmentLikeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLikeBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWineRecommand("pick",1)
        binding.LikeListRecycle.layoutManager = GridLayoutManager(requireContext() ,2)
        binding.LikeListRecycle.addItemDecoration(RecyclerViewDecoration(0,20))

        viewModel.liveWineList_recommand_2.observe(viewLifecycleOwner, Observer {
            val wineListRVAdapter = WineListVPAdapter(requireContext(), it)
            binding.LikeListRecycle.adapter = wineListRVAdapter

//            binding.wineListRecycler2.addItemDecoration(RecyclerViewDecoration(20,0))

            wineListRVAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }

        })

    }



}