package com.practice.mvpdemo.view.main.presenter

import android.content.Context

interface MainContract {
    interface View {
        fun showToast(title: String)
    }

    interface Presenter {
        fun loadItem(context: Context, isClear: Boolean)
    }
}