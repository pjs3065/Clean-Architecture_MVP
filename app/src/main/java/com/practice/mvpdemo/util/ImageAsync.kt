package com.practice.mvpdemo.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.lang.ref.WeakReference

class ImageAsync(private val context: Context, imageView: ImageView?) :
    AsyncTask<Int, Void, Bitmap>() {

    private val imageReference = WeakReference(imageView)

    override fun doInBackground(vararg params: Int?): Bitmap {
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        return BitmapFactory.decodeResource(context.resources, params[0] as Int, options)
    }

    override fun onPreExecute() {
        super.onPreExecute()
        //clear 초기화
        imageReference.get()?.setImageResource(0)
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        result?.let {
            imageReference.get()?.setImageBitmap(it)
        }
    }
}