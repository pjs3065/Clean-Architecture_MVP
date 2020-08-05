package com.practice.mvpdemo.view.main.presenter

import android.content.Context
import com.practice.mvpdemo.adapter.contract.ImageAdapterContract
import com.practice.mvpdemo.data.ImageItem
import com.practice.mvpdemo.data.source.image.SampleImageSource
import com.practice.mvpdemo.data.source.image.SampleRepository

class  MainPresenter(
    private val view: MainContract.View,
    private val imageData: SampleRepository,
    private val adapterView: ImageAdapterContract.View,
    private val adapterModel: ImageAdapterContract.Model
): MainContract.Presenter {

    init{
        adapterView.onClickFunc = {
            onClickListener(it)
        }
    }

    override fun loadItem(context: Context, isClear: Boolean) {
        imageData.getImages(context, 15, object: SampleImageSource.LoadImageCallback{
            override fun onLoadImages(list: MutableList<ImageItem>) {
                if(isClear){
                    adapterModel.clearItems()
                }
                adapterModel.addItems(list)
                adapterView.notifyAdapter()
            }
        })
    }

    private fun onClickListener(position: Int){
        adapterModel.getItem(position).let{
            view.showToast(it.title)
        }
    }
}