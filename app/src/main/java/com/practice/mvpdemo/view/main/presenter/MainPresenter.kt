package com.practice.mvpdemo.view.main.presenter

import android.content.Context
import com.practice.mvpdemo.adapter.contract.ImageAdapterContract
import com.practice.mvpdemo.data.ImageData

class  MainPresenter(
    private val view: MainContract.View,
    private val imageData: ImageData,
    private val adapterView: ImageAdapterContract.View,
    private val adapterModel: ImageAdapterContract.Model
): MainContract.Presenter {

    init{
        adapterView.onClickFunc = {
            onClickListener(it)
        }
    }

    override fun loadItem(context: Context, isClear: Boolean) {
        imageData.getSampleList(context, 15).let{
            if(isClear){
                adapterModel.clearItems()
            }
            adapterModel.addItems(it)
            adapterView.notifyAdapter()
        }
    }

    private fun onClickListener(position: Int){
        adapterModel.getItem(position).let{
            view.showToast(it.title)
        }
    }
}