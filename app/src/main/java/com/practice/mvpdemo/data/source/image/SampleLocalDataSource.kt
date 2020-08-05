package com.practice.mvpdemo.data.source.image

import android.content.Context
import com.practice.mvpdemo.data.ImageItem

object SampleLocalDataSource:SampleImageSource {

    override fun getImages(
        context: Context,
        size: Int,
        loadImageCallback: SampleImageSource.LoadImageCallback
    ) {
        val list = mutableListOf<ImageItem>()
        for (i in 1..size) {
            val name = String.format("sample_%02d", (Math.random() * 15).toInt())
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
        }
        loadImageCallback.onLoadImages(list)
    }
}