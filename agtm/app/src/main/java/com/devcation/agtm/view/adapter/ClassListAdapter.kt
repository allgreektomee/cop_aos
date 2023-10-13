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
import java.text.DecimalFormat


class ClassListAdapter (val context: Context, var dataSet: List<AgtmClassResult>) : RecyclerView.Adapter<ClassListAdapter.ViewHolder>(){



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


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_class, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.classTitle.text = dataSet[position].title



        Glide.with(context)
            .load(dataSet[position].photos[0].file)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.classImg)


        holder.classSubtitle.text = dataSet[position].subtitle
        holder.classPlace.text = dataSet[position].place

        val dec = DecimalFormat("#,###")

        holder.classEtc.text =  dataSet[position].start +" - "+ dataSet[position].end+ "  "+dec.format( dataSet[position].price)+"원"

        holder.itemView.setOnClickListener{ v ->
            itemClick?.onClick(v, dataSet[position].pk)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}