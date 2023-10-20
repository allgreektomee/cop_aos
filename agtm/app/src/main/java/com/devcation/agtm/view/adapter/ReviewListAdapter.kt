package com.devcation.agtm.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.R
import com.devcation.agtm.dataModel.notice.NoticeResult
import com.devcation.agtm.dataModel.reviews.ReviewResult

class ReviewListAdapter(val context: Context, var dataSet: MutableList<ReviewResult>?) : RecyclerView.Adapter<ReviewListAdapter.ViewHolder>(){



    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val reviewImg = view.findViewById<ImageView>(R.id.reviews_owner_img)

        val reviewName = view.findViewById<TextView>(R.id.reviews_owner_name)

        val reviewComent = view.findViewById<TextView>(R.id.review_coment)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_reviews, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.reviewName.text = dataSet?.get(position)?.user?.username






        Glide.with(context)
            .load(dataSet?.get(position)?.user?.img)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.reviewImg)


        holder.reviewComent.text = dataSet?.get(position)?.comment + "\n\n" + dataSet?.get(position)?.update_at


    }

    override fun getItemCount(): Int {
        return dataSet?.size!!
    }

}