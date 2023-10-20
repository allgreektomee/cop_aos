package com.devcation.agtm.view.main

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer

import com.devcation.agtm.R

import com.devcation.agtm.databinding.ActivityWineDetailBinding
import com.devcation.agtm.viewModel.MainViewModel

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineReviewResult
import com.devcation.agtm.view.adapter.ReviewListAdapter
import com.devcation.agtm.view.adapter.WineListVPAdapter
import com.devcation.agtm.view.adapter.WineTypeGridAdapter
import java.text.DecimalFormat


class WineDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWineDetailBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var pk = 0
        var isLike = false

        var username = UserManager.getInstance(applicationContext).userName

        binding = ActivityWineDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.getWineDetail(username,intent.getIntExtra("pk", 0))
        viewModel.liveWineDetail.observe(this) {

            Glide.with(this)
                .load(it.photos[0].file)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.mainWineDetailImg)

            binding.mainWineName.text = it.name
            binding.mainWineNameEn.text = it.name_en

            var country = it.country.name
            var region = it.region.name
            var grapes = it.grapes.name
            var alcohol = it.Alcohol.toString()
            var type : String


            when (it.type) {
                "red" -> type = "Red"
                "white" -> type = "White"
                "natural" -> type = "Natural"
                "rose" -> type = "Rose"
                "sweet" -> type = "Sweet"
                "sparkling" -> type = "Sparkling"
                else -> type = ""
            }

            binding.mainWineCountry.text = "$alcohol ℃  $type ㆍ $country ㆍ $region ㆍ $grapes"


            var sugar = it.taste_sugar.toString()
            var acidity = it.taste_acidity.toString()
            var tannin = it.taste_tannin.toString()
            var body = it.taste_body.toString()

            binding.tvTaste.text = "바디 $body /5 ㆍ 당도 $sugar /5 ㆍ 산미 $acidity /5  ㆍ 탄닌 $tannin /5"


            var styles = StringBuilder()
            it.styles.forEach {
                styles.append(it.name)
                styles.append("  ")
            }
            binding.tvStyles.text = styles


            var pairings = StringBuilder()
            it.pairings.forEach {
                pairings.append(it.name)
                pairings.append("  ")
            }
            binding.tvPairings.text = pairings

            binding.tvDescription.text = it.description

            val dec = DecimalFormat("#,###")
            binding.mainWineCost.text = dec.format(it.price)

            pk = it.id
//            viewModel.getWineReviews(it.id,"devcation", 1)
            isLike = it.is_liked
            if( it.is_liked ){
                binding.wineDetailLike.setColorFilter(resources.getColor(R.color.icon_pink))
            }else{
                binding.wineDetailLike.setColorFilter(resources.getColor(R.color.icon_gray))
            }

        }


//        viewModel.liveWineReviews.observe(this) {
//
//            val reviewListAdapter = ReviewListAdapter(this, it)
//            binding.WineReviewsRecycler.adapter =reviewListAdapter
//            binding.WineReviewsRecycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//        }


        binding.wineDetailReply.setOnClickListener(){
            val intent = Intent(this, WineReplyActivity::class.java)
            intent.putExtra("pk",pk)
            startActivity(intent)
        }


        binding.wineDetailLike.setOnClickListener(){

            if( isLike ){
                isLike = false
                binding.wineDetailLike.setColorFilter(resources.getColor(R.color.icon_gray))
            }else{
                isLike = true
                binding.wineDetailLike.setColorFilter(resources.getColor(R.color.icon_pink))

            }

            var type : LikeType
            type = LikeType("LIKE")

            viewModel.getWineLikeToggle(username,pk, type)
        }



    }
}