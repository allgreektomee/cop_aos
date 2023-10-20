package com.devcation.agtm.view.notice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.R
import com.devcation.agtm.databinding.ActivityNoticeDetailBinding
import com.devcation.agtm.databinding.ActivityWineDetailBinding
import com.devcation.agtm.viewModel.MainViewModel
import com.devcation.agtm.viewModel.NoticeViewModel

class NoticeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoticeDetailBinding
    lateinit var viewModel: NoticeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoticeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(NoticeViewModel::class.java)


        viewModel.getNoticeDetail(intent.getIntExtra("id", 0))

        viewModel.liveNoticeDetail.observe(this) {

            Glide.with(this)
                .load(it.owner.img)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.noticeOwnerImg)

            binding.noticeOwnerName.text = it.owner.username
            binding.noticeDate.text = it.update_at

            binding.noticeName.text = it.name
            binding.noticeNameEn.text =it.name_en
            binding.noticeDes.text = it.description



            for (photo in it.photos){
                if (photo.description == "notice"){
                    Glide.with(this)
                        .load(photo.file)
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(binding.noticeDetailImg)
                }
            }


            binding.noticeName.text = it.name
            binding.noticeNameEn.text =it.name_en
            binding.noticeDes.text = it.description



            Glide.with(this)
                .load(it.photos[0].file)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.noticeSubImg1)

            Glide.with(this)
                .load(it.photos[1].file)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.noticeSubImg2)

            Glide.with(this)
                .load(it.photos[2].file)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(binding.noticeSubImg3)
        }
    }
}