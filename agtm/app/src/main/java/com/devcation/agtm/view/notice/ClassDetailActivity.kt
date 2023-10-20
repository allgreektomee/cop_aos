package com.devcation.agtm.view.notice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.R
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.databinding.ActivityClassDetailBinding
import com.devcation.agtm.databinding.ActivityNoticeDetailBinding
import com.devcation.agtm.view.main.WineReplyActivity
import com.devcation.agtm.viewModel.ClassViewModel
import com.devcation.agtm.viewModel.NoticeViewModel
import java.text.DecimalFormat

class ClassDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClassDetailBinding
    lateinit var viewModel: ClassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var pk = intent.getIntExtra("id", 0)
        var isLike = false

        var username = UserManager.getInstance(applicationContext).userName


        binding = ActivityClassDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ClassViewModel::class.java)

        viewModel.getAgtmClassDetail(pk, UserManager.getInstance(applicationContext).userName)
        viewModel.liveClassDetail.observe(this) {

            Glide.with(this)
                .load(it.owner.img)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.classOwnerImg)


            Glide.with(this)
                .load(it.photos[0].file)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.classDetailImg)

            binding.classOwnerName.text = it.owner.username
            binding.classDate.text = it.update_at
            binding.classTitle.text = it.title
            binding.classSubtitle.text =  it.place +",  " +it.subtitle

            val dec = DecimalFormat("#,###")
            binding.classPlace.text = it.address
            binding.classCost.text = it.start + " - "+ it.end +",  "+dec.format(it.price)+"원"

            binding.tvDescription.text =it.description


            isLike = it.is_liked
            if( it.is_liked ){
                binding.classDetailLike.setColorFilter(resources.getColor(R.color.icon_pink))
            }else{
                binding.classDetailLike.setColorFilter(resources.getColor(R.color.icon_gray))
            }

        }

        binding.classDetailLike.setOnClickListener(){
            if( isLike ){
                isLike = false
                binding.classDetailLike.setColorFilter(resources.getColor(R.color.icon_gray))
            }else{
                isLike = true
                binding.classDetailLike.setColorFilter(resources.getColor(R.color.icon_pink))

            }

            var type : LikeType
            type = LikeType("LIKE")

            viewModel.getAgtmClassLikeToggle(username,pk, type)
        }

        binding.classDetailReply.setOnClickListener(){
            val intent = Intent(this, ClassReplyActivity::class.java)
            intent.putExtra("pk",pk)
            startActivity(intent)
        }
    }
}