package com.devcation.agtm.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.R
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.reviews.Review
import com.devcation.agtm.databinding.ActivityWineDetailBinding
import com.devcation.agtm.databinding.ActivityWineReplyBinding
import com.devcation.agtm.view.adapter.ReviewListAdapter
import com.devcation.agtm.viewModel.MainViewModel

class WineReplyActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWineReplyBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var username = UserManager.getInstance(applicationContext).userName

        binding = ActivityWineReplyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pk = intent.getIntExtra("pk", 0)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.getWineReviews( pk,username, 1)

        viewModel.liveWineReviews.observe(this) {

            val reviewListAdapter = ReviewListAdapter(this, it )
            binding.ReviewsRecycler.adapter =reviewListAdapter
            binding.ReviewsRecycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }


        binding.replyComment.hint =  username +"(으)로 댓글 달기..."


        Glide.with(applicationContext)
            .load( UserManager.getInstance(applicationContext).me.img )
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into( binding.wineLikeImg)

        binding.btnRely.setOnClickListener(){



            viewModel.wineReviews(pk,username,1, Review(pk, binding.replyComment.text.toString(),"5") )
        }

    }
}