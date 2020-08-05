package com.practice.mvpdemo.data.source.image

import android.content.Context
import com.practice.mvpdemo.data.ImageItem

object SampleRepository: SampleImageSource {

    override fun getImages(
        context: Context,
        size: Int,
        loadImageCallback: SampleImageSource.LoadImageCallback
    ) {
        SampleLocalDataSource.getImages(context, size, object: SampleImageSource.LoadImageCallback{
            override fun onLoadImages(list: MutableList<ImageItem>) {
                loadImageCallback.onLoadImages(list)
            }
        })
    }
}