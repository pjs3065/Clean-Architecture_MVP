package com.practice.mvpdemo.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practice.mvpdemo.adapter.contract.ImageAdapterContract
import com.practice.mvpdemo.data.ImageItem

class ImageAdapter:RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.View, ImageAdapterContract.Model {
    var itemList = mutableListOf<ImageItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(parent, onClickFunc)

    override var onClickFunc: ((Int) -> Unit)? = null

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        getItem(position).let{
            holder.onBind(it, position)
        }
    }

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItems(items: MutableList<ImageItem>) {
        itemList = items
    }

    override fun clearItems() {
        itemList.clear()
    }

    override fun getItem(position: Int) = itemList[position]
}