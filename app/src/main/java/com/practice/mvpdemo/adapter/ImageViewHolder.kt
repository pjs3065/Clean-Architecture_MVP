package com.practice.mvpdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practice.mvpdemo.R
import com.practice.mvpdemo.data.ImageItem
import com.practice.mvpdemo.util.ImageAsync

class ImageViewHolder(parent: ViewGroup, private val onClickFunc: ((Int) -> Unit)?) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_image, parent, false
        )
    ) {
    private val imageView by lazy {
        itemView.findViewById(R.id.img_view) as ImageView
    }

    private val textView by lazy {
        itemView.findViewById(R.id.text) as TextView
    }

    fun onBind(item: ImageItem, position: Int) {
        ImageAsync(imageView.context, imageView).execute(item.resources)
        textView.text = item.title

        imageView.setOnClickListener {
            onClickFunc?.invoke(position)
        }
    }
}
