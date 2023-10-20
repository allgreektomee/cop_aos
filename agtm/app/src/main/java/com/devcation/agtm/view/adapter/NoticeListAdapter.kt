package com.devcation.agtm.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.devcation.agtm.R
import com.devcation.agtm.dataModel.notice.NoticeResult
import com.devcation.agtm.viewModel.NoticeViewModel


class NoticeListAdapter(val context: Context, var dataSet: List<NoticeResult>) : RecyclerView.Adapter<NoticeListAdapter.ViewHolder>(){

    val notiTypes = listOf("0","Notice","Event","Magazine","Banner","Link")

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val notiImg = view.findViewById<ImageView>(R.id.item_noti_img)

        val notiType = view.findViewById<TextView>(R.id.item_noti_type)

        val notiTitle = view.findViewById<TextView>(R.id.item_noti_title)
        val notiDescription = view.findViewById<TextView>(R.id.item_noti_des)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_notice, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.notiTitle.text = dataSet[position].name

        for (photo in dataSet[position].photos){
            if (photo.description == "notice"){
                Glide.with(context)
                    .load(photo.file)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.notiImg)
            }
        }


        holder.notiType.text = notiTypes[dataSet[position].type.toInt()]
        holder.notiDescription.text = dataSet[position].description

        holder.itemView.setOnClickListener{ v ->
            itemClick?.onClick(v, dataSet[position].id)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}