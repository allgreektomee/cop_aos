package com.devcation.agtm.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.devcation.agtm.common.RecyclerViewDecoration
import com.devcation.agtm.databinding.ActivityWineTypeBinding
import com.devcation.agtm.view.adapter.WineListVPAdapter
import com.devcation.agtm.view.adapter.WineTypeGridAdapter
import com.devcation.agtm.viewModel.MainViewModel
import com.devcation.agtm.viewModel.WineTypeViewModel

class WineTypeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWineTypeBinding

    lateinit var viewModel: WineTypeViewModel

    val wineTypes_str = listOf("red","white","natural","rose","sweet","sparkling")
    val wineTypes = listOf(0,1,2,3,4,5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWineTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(WineTypeViewModel::class.java)


        viewModel.getWineType(wineTypes_str[intent.getIntExtra("type", 0)],1)

        //
        binding.recycleviewWineType.layoutManager = GridLayoutManager(applicationContext ,2)
        binding.recycleviewWineType.addItemDecoration(RecyclerViewDecoration(0,20))
        viewModel.liveWineType_red.observe(this) {
            val wineTypeListVPAdapter = WineListVPAdapter(this, it)
            wineTypeListVPAdapter.itemViewType(1)
            binding.recycleviewWineType.adapter = wineTypeListVPAdapter



            wineTypeListVPAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(applicationContext, WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        }

        //

        viewModel.liveWineType_white.observe(this) {
            val wineTypeListVPAdapter = WineListVPAdapter(this, it)
            wineTypeListVPAdapter.itemViewType(1)
            binding.recycleviewWineType.adapter = wineTypeListVPAdapter



            wineTypeListVPAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(applicationContext, WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        }


        //

        viewModel.liveWineType_natural.observe(this) {
            val wineTypeListVPAdapter = WineListVPAdapter(this, it)
            wineTypeListVPAdapter.itemViewType(1)
            binding.recycleviewWineType.adapter = wineTypeListVPAdapter



            wineTypeListVPAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(applicationContext, WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        }

        //
        viewModel.liveWineType_rose.observe(this) {
            val wineTypeListVPAdapter = WineListVPAdapter(this, it)
            wineTypeListVPAdapter.itemViewType(1)
            binding.recycleviewWineType.adapter = wineTypeListVPAdapter



            wineTypeListVPAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(applicationContext, WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        }

        //
        viewModel.liveWineType_sweet.observe(this) {
            val wineTypeListVPAdapter = WineListVPAdapter(this, it)
            wineTypeListVPAdapter.itemViewType(1)
            binding.recycleviewWineType.adapter = wineTypeListVPAdapter



            wineTypeListVPAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(applicationContext, WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        }

        //
        viewModel.liveWineType_sparkling.observe(this) {
            val wineTypeListVPAdapter = WineListVPAdapter(this, it)
            wineTypeListVPAdapter.itemViewType(1)
            binding.recycleviewWineType.adapter = wineTypeListVPAdapter



            wineTypeListVPAdapter.itemClick = object : WineListVPAdapter.ItemClick {
                override fun onClick(view: View, pk: Int) {

                    val intent = Intent(applicationContext, WineDetailActivity::class.java)
                    intent.putExtra("pk",pk)
                    startActivity(intent)
                }
            }
        }


        val wineTypeRVadapter = WineTypeGridAdapter(this, wineTypes )
        binding.recyclerView.adapter = wineTypeRVadapter
        binding.recyclerView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        wineTypeRVadapter.itemClick = object : WineTypeGridAdapter.ItemClick {
            override fun onClick(view: View, type: Int) {
                reqWineType(type)

            }
        }

    }

    fun reqWineType(type:Int){
        viewModel.getWineType(wineTypes_str[type],1)
    }
}