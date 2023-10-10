package com.devcation.agtm.view.adapter

import android.content.Context
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.devcation.agtm.R


class WineTypeGridAdapter (val context: Context, var dataSet: List<Int>) : RecyclerView.Adapter<WineTypeGridAdapter.ViewHolder>(){

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val wineType = view.findViewById<TextView>(R.id.listTvWineType)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_wine_type, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wineType.text = dataSet[position].toString()
        Log.d("Main", dataSet[position].toString())

        holder.itemView.setOnClickListener{ v ->
            itemClick?.onClick(v, dataSet[position])
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}