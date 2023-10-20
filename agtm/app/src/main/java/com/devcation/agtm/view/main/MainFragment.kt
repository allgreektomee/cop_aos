package com.devcation.agtm.view.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.devcation.agtm.R
import com.devcation.agtm.common.RecyclerViewDecoration
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.databinding.FragmentMainBinding
import com.devcation.agtm.view.adapter.WineListVPAdapter
import com.devcation.agtm.view.adapter.WineTypeGridAdapter
import com.devcation.agtm.viewModel.MainViewModel
import com.devcation.agtm.viewModel.UserViewModel
import timber.log.Timber
import java.util.Collections.list


class MainFragment : Fragment() {
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainViewModel by activityViewModels()

    val wineTypes = listOf(0,1,2,3,4,5)

    private val userViewModel : UserViewModel by activityViewModels()
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


//
//        userViewModel.getUserWineReviews("devcation",1)



//        viewModel.getWineLikeToggle("devcation",1, LikeType("LIKE"))

        var username = UserManager.getInstance(requireContext()).userName
        userViewModel.me(username)
        userViewModel.liveUserData.observe(viewLifecycleOwner, Observer {
            UserManager.getInstance(requireContext()).me = it
        })

        viewModel.getWineRecommand(username,"agtm",1)
        viewModel.liveWineList_recommand_1.observe(viewLifecycleOwner, Observer {
            val wineListRVAdapter = WineListVPAdapter(requireContext(), it)

            binding.wineListRecycler.adapter = wineListRVAdapter
            binding.wineListRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            binding.wineListRecycler.addItemDecoration(RecyclerViewDecoration(0,0))

            wineListRVAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        })





        viewModel.getWineRecommand(username,"pick",1)
        viewModel.liveWineList_recommand_2.observe(viewLifecycleOwner, Observer {
            val wineListRVAdapter = WineListVPAdapter(requireContext(), it)
            binding.wineListRecycler2.adapter = wineListRVAdapter
            binding.wineListRecycler2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            binding.wineListRecycler2.addItemDecoration(RecyclerViewDecoration(20,0))

            wineListRVAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }

        })

        viewModel.getWineRecommand(username,"month",1)
        viewModel.liveWineList_recommand_3.observe(viewLifecycleOwner, Observer {
            val wineListRVAdapter = WineListVPAdapter(requireContext(), it)
            binding.wineListRecycler3.adapter = wineListRVAdapter
            binding.wineListRecycler3.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            binding.wineListRecycler3.addItemDecoration(RecyclerViewDecoration(20,0))

            wineListRVAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        })

        val wineTypeRVadapter = WineTypeGridAdapter(requireContext(), wineTypes )
        binding.wineTypeRecycler.adapter = wineTypeRVadapter
        binding.wineTypeRecycler.layoutManager = GridLayoutManager(requireContext(),3)

        wineTypeRVadapter.itemClick = object : WineTypeGridAdapter.ItemClick {
            override fun onClick(view: View, type: Int) {

                val intent = Intent(requireContext(), WineTypeActivity::class.java)
                intent.putExtra("type",type)
                startActivity(intent)
            }
        }
    }
}