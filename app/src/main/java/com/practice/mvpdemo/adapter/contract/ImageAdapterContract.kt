package com.practice.mvpdemo.adapter.contract

import com.practice.mvpdemo.data.ImageItem

interface ImageAdapterContract {
    interface View{
        var onClickFunc: ((Int) -> Unit)?

        fun notifyAdapter()
    }

    interface Model{
        fun addItems(items:MutableList<ImageItem>)

        fun clearItems()

        fun getItem(position: Int):ImageItem
    }
}