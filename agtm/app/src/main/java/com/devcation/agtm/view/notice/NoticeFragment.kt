package com.devcation.agtm.view.notice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.devcation.agtm.R
import com.devcation.agtm.common.RecyclerViewDecoration
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.databinding.FragmentNoticeBinding
import com.devcation.agtm.view.adapter.ClassListAdapter
import com.devcation.agtm.view.adapter.NoticeListAdapter
import com.devcation.agtm.view.adapter.WineListVPAdapter
import com.devcation.agtm.view.main.WineDetailActivity
import com.devcation.agtm.viewModel.ClassViewModel
import com.devcation.agtm.viewModel.NoticeViewModel


class NoticeFragment : Fragment() {

    private var _binding : FragmentNoticeBinding? = null
    private val binding get() = _binding!!

    private val noticeViewModel: NoticeViewModel by activityViewModels()
    private val classViewModel: ClassViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoticeBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //notice
        noticeViewModel.getNoticeType(3, 1)

        binding.NoticeListRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.NoticeListRecycler.addItemDecoration(RecyclerViewDecoration(0,0))
        noticeViewModel.liveNotice_magazine.observe(viewLifecycleOwner, Observer {
            val noticeListAdapter = NoticeListAdapter(requireContext(), it)

            binding.NoticeListRecycler.adapter = noticeListAdapter

//

            noticeListAdapter.itemClick = object : NoticeListAdapter.ItemClick {
                override fun onClick(view: View, id: Int) {

                    val intent = Intent(requireContext(), NoticeDetailActivity::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                }
            }
        })

        //class
        classViewModel.getAgtmClass(UserManager.getInstance(requireContext()).userName, 1)
        binding.classListRecycler.addItemDecoration(RecyclerViewDecoration(0,20))
        binding.classListRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        classViewModel.liveClassList.observe(viewLifecycleOwner, Observer {
            val classListAdapter = ClassListAdapter(requireContext(), it)
            binding.classListRecycler.adapter = classListAdapter



            classListAdapter.itemClick = object : ClassListAdapter.ItemClick {
                override fun onClick(view: View, id: Int) {

                    val intent = Intent(requireContext(), ClassDetailActivity::class.java)
                    intent.putExtra("id",id)
                    startActivity(intent)
                }
            }
        })


    }
}