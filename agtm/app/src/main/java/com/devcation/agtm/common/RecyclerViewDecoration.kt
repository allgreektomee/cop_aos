package com.devcation.agtm.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView



class RecyclerViewDecoration(private val right: Int, private val bottom: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = bottom
        outRect.right = right
    }
}