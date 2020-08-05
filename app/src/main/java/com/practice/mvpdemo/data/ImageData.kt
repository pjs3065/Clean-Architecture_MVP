package com.practice.mvpdemo.data

import android.content.Context

object ImageData {
    fun getSampleList(context: Context, size: Int): MutableList<ImageItem> {
        val list = mutableListOf<ImageItem>()
        for (i in 1..size) {
            val name = String.format("sample_%02d", (Math.random() * 15).toInt())
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
        }
        return list
    }
}