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
import com.devcation.agtm.dataModel.agtmClass.AgtmClassResult
import com.devcation.agtm.dataModel.like.LikesClassResult
import java.text.DecimalFormat


class ClassLikeListAdapter (val context: Context, var dataSet: List<LikesClassResult>) : RecyclerView.Adapter<ClassLikeListAdapter.ViewHolder>(){



    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val classImg = view.findViewById<ImageView>(R.id.item_class_img)

        val classTitle = view.findViewById<TextView>(R.id.item_class_title)
        val classSubtitle = view.findViewById<TextView>(R.id.item_class_subtitle)

        val classPlace = view.findViewById<TextView>(R.id.item_class_place)
        val classEtc = view.findViewById<TextView>(R.id.item_class_etc)

        val classLike = view.findViewById<ImageView>(R.id.wine_main_like)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_class, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.classTitle.text = dataSet[position].agtmclass.title



        Glide.with(context)
            .load(dataSet[position].agtmclass.photos[0].file)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.classImg)


        holder.classSubtitle.text = dataSet[position].agtmclass.subtitle
        holder.classPlace.text = dataSet[position].agtmclass.place

        val dec = DecimalFormat("#,###")

        holder.classEtc.text =  dataSet[position].agtmclass.start +" - "+ dataSet[position].agtmclass.end+ "  "+dec.format( dataSet[position].agtmclass.price)+"원"

        holder.itemView.setOnClickListener{ v ->
            itemClick?.onClick(v, dataSet[position].agtmclass.pk)
        }

        holder.classLike.setColorFilter(context.getColor(R.color.icon_pink))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}