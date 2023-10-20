package com.devcation.agtm.view.notice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.R
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.reviews.Review
import com.devcation.agtm.databinding.ActivityClassReplyBinding

import com.devcation.agtm.view.adapter.ReviewListAdapter
import com.devcation.agtm.viewModel.ClassViewModel


class ClassReplyActivity : AppCompatActivity() {


    private lateinit var binding: ActivityClassReplyBinding
    lateinit var viewModel: ClassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClassReplyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pk = intent.getIntExtra("pk", 0)
        var username = UserManager.getInstance(applicationContext).userName


        viewModel = ViewModelProvider(this).get(ClassViewModel::class.java)


        viewModel.getReviews( pk,username, 1)

        viewModel.liveReviews.observe(this) {

            val reviewListAdapter = ReviewListAdapter(this, it )
            binding.ReviewsRecycler.adapter =reviewListAdapter
            binding.ReviewsRecycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }

        binding.classReplyComment.hint =  username +"(으)로 댓글 달기..."

        Glide.with(applicationContext)
            .load( UserManager.getInstance(applicationContext).me.img )
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into( binding.classLikeImg)

        binding.btnClassRely.setOnClickListener(){



            viewModel.reviews(pk,username,1, Review(pk, binding.classReplyComment.text.toString(),"5") )
        }

    }
}