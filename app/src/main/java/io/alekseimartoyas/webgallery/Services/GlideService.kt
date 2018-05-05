package io.alekseimartoyas.webgallery.Services

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

interface GlideServiceInput {
    fun getPhoto(context: Context, imageView: ImageView, url: String)
}

class GlideService : GlideServiceInput {
    override fun getPhoto(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .into(imageView)
    }
}