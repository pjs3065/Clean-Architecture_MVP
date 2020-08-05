package com.practice.mvpdemo.data.source.image

import android.content.Context
import com.practice.mvpdemo.data.ImageItem

interface SampleImageSource {
    interface LoadImageCallback{
        fun onLoadImages(list:MutableList<ImageItem>)
    }

    fun getImages(context: Context, size:Int, loadImageCallback:LoadImageCallback)
}