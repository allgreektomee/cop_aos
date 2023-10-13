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
import com.devcation.agtm.dataModel.wine.WineResult


class WineListVPAdapter(val context: Context, var dataSet: List<WineResult>) : RecyclerView.Adapter<WineListVPAdapter.ViewHolder>(){

    val VIEWTYPE_MAIN = 0
    val VIEWTYPE_WINETYPE = 1
    var itemViewType = 0

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val wineImg = view.findViewById<ImageView>(R.id.main_wine_img)

        val wineName = view.findViewById<TextView>(R.id.item_class_subtitle)

        val wineCountry = view.findViewById<TextView>(R.id.item_class_place)
        val wineType = view.findViewById<TextView>(R.id.main_wine_type)

        var wineLike  = view.findViewById<ImageView>(R.id.wine_main_like)
        var list_item = view.findViewById<ConstraintLayout>(R.id.list_item)
        var list_item_bg = view.findViewById<ConstraintLayout>(R.id.list_item_bg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_wine, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.wineName.text = dataSet[position].name

        if (itemViewType == VIEWTYPE_MAIN){

            holder.list_item.setLayoutParams(ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT))

        }else{

            holder.list_item.setLayoutParams(ViewGroup.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.WRAP_CONTENT))

            val param = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            param.marginEnd = 0
            holder.list_item_bg.setLayoutParams(param)
        }

        if(dataSet[position].is_liked){
            holder.wineLike.setColorFilter(Color.parseColor("#D06060"))
        }

        Glide.with(context)
            .load(dataSet[position].photos[0].file)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder.wineImg)

        holder.wineCountry.text = dataSet[position].country["name"] as String

        holder.wineType.text = dataSet[position].type

        holder.itemView.setOnClickListener{ v ->
            itemClick?.onClick(v, dataSet[position].pk)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun itemViewType(viewType: Int) {
        itemViewType = viewType
    }
}