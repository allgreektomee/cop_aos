package com.devcation.agtm.view.like

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.devcation.agtm.R
import com.devcation.agtm.common.RecyclerViewDecoration
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.databinding.FragmentLikeBinding
import com.devcation.agtm.databinding.FragmentMainBinding
import com.devcation.agtm.view.adapter.ClassLikeListAdapter
import com.devcation.agtm.view.adapter.WineLikeListVPAdapter
import com.devcation.agtm.view.adapter.WineListVPAdapter
import com.devcation.agtm.view.main.WineDetailActivity
import com.devcation.agtm.viewModel.MainViewModel
import com.devcation.agtm.viewModel.UserViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LikeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LikeFragment : Fragment() {

    private var _binding : FragmentLikeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : UserViewModel by activityViewModels()

    private var isLike:Boolean = true
    private var isWine:Boolean = true

    private var username :String = ""

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

        username = UserManager.getInstance(requireContext()).userName
        wishTitleSetting()




        viewModel.getUserWineLikes(username,1)
        binding.LikeListRecycle.addItemDecoration(RecyclerViewDecoration(0,20))

        viewModel.liveLikeWine.observe(viewLifecycleOwner, Observer {
            val wineLikeListVPAdapter = WineLikeListVPAdapter(requireContext(), it)
            binding.LikeListRecycle.adapter = wineLikeListVPAdapter
            binding.LikeListRecycle.layoutManager = GridLayoutManager(requireContext() ,2)


//            binding.wineListRecycler2.addItemDecoration(RecyclerViewDecoration(20,0))

            wineLikeListVPAdapter.itemClick = object : WineLikeListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
            

        })

        viewModel.liveOrderWine.observe(viewLifecycleOwner, Observer {
            val wineLikeListVPAdapter = WineLikeListVPAdapter(requireContext(), it)
            binding.LikeListRecycle.adapter = wineLikeListVPAdapter
            binding.LikeListRecycle.layoutManager = GridLayoutManager(requireContext() ,2)


//            binding.wineListRecycler2.addItemDecoration(RecyclerViewDecoration(20,0))

            wineLikeListVPAdapter.itemClick = object : WineLikeListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }


        })

        viewModel.liveLikeClass.observe(viewLifecycleOwner, Observer {
            val classLikeListAdapter = ClassLikeListAdapter(requireContext(), it)
            binding.LikeListRecycle.adapter = classLikeListAdapter
            binding.LikeListRecycle.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


            classLikeListAdapter.itemClick = object : ClassLikeListAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }

        })

        viewModel.liveOrderClass.observe(viewLifecycleOwner, Observer {
            val classLikeListAdapter = ClassLikeListAdapter(requireContext(), it)
            binding.LikeListRecycle.adapter = classLikeListAdapter
            binding.LikeListRecycle.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


            classLikeListAdapter.itemClick = object : ClassLikeListAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(requireContext(), WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }

        })



        binding.btnLike.setOnClickListener(){
            isLike = true
            isWine = true

            viewModel.getUserWineLikes(username,1)

            wishTitleSetting()

        }

        binding.btnOrder.setOnClickListener(){
            isLike = false
            isWine = true

            viewModel.getUserWineOrder(username,1)

            wishTitleSetting()
        }

        binding.btnWine.setOnClickListener(){
            isWine = true
            wishTitleSetting()

            if(isLike){
                viewModel.getUserWineLikes(username,1)
            }else{
                viewModel.getUserWineOrder(username,1)
            }



        }

        binding.btnClass.setOnClickListener(){
            isWine = false
            wishTitleSetting()

            if(isLike){
                viewModel.getUserClassLikes(username,1)
            }else{
                viewModel.getUserClassOrder(username,1)
            }





        }
    }


    fun wishTitleSetting(){
        if (isLike){
            binding.btnLike.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            binding.btnOrder.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_gray))
            if(isWine){
                binding.textWishTitle.text ="관심있는 모든 와인"
            }else{
                binding.textWishTitle.text ="관심있는 모든 클래스"
            }


        }else{
            binding.btnLike.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_gray))
            binding.btnOrder.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

            if(isWine){
                binding.textWishTitle.text ="구매한 모든 와인"
            }else{
                binding.textWishTitle.text ="참여한 모든 클래스"
            }

        }


        if(isWine){
            binding.btnWine.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            binding.btnClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_gray))
            binding.btnWine.background = ResourcesCompat.getDrawable(resources, R.drawable.round_shape_list_img, null)
            binding.btnClass.background = ResourcesCompat.getDrawable(resources, R.drawable.round_shape_bg, null)

        }else{
            binding.btnClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
            binding.btnWine.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_gray))
            binding.btnClass.background = ResourcesCompat.getDrawable(resources, R.drawable.round_shape_list_img, null)
            binding.btnWine.background = ResourcesCompat.getDrawable(resources, R.drawable.round_shape_bg, null)

        }

    }
}