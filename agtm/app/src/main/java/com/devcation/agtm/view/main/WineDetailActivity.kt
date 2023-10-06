package com.devcation.agtm.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer

import com.devcation.agtm.R

import com.devcation.agtm.databinding.ActivityWineDetailBinding
import com.devcation.agtm.viewModel.MainViewModel

import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineReviewResult
import java.text.DecimalFormat


class WineDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWineDetailBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wine_detail)


        binding = ActivityWineDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.getWineDetail(intent.getIntExtra("pk", 0))
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

        }


    }

}