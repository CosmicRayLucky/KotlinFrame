package com.example.zaq.kotlinframe.core

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.example.zaq.kotlinframe.GlideApp
import com.example.zaq.kotlinframe.R
import java.util.concurrent.ExecutionException

/**
 * Created by Zhang Aqi on 2018/12/10. 13:43
 * mail:1095187377@qq.com
 */
object GlideUtils {
    /**
     * 用于一些内存中的小图标等
     */
    fun normal(context: Context, o: Any, imageView: ImageView) {
        GlideApp.with(context).load(o).error(R.mipmap.ic_launcher).into(imageView)
    }

    /**
     * 圆形头像
     */
    fun headPhoto(context: Context, o: Any, imageView: ImageView) {
        GlideApp.with(context)
            .load(o)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round)
            .into(imageView)
    }


    /**
     * 获取bitmap
     *
     * @param context
     * @param o
     * @param size
     * @return
     */
    @Throws(ExecutionException::class, InterruptedException::class)
    fun getImgBitmap(context: Context, o: Any, size: Int): Bitmap {
        return GlideApp.with(context)
            .asBitmap()
            .load(o)
            .submit(size, size)
            .get()
    }
}