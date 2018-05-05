package io.alekseimartoyas.webgallery.Services

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.alekseimartoyas.webgallery.R

interface GlideServiceInput {
    fun getPhoto(context: Context, imageView: ImageView, url: String)
}

class GlideService : GlideServiceInput {
    override fun getPhoto(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .error(R.drawable.abc_ic_clear_material)
//                .asBitmap()
                .placeholder(R.drawable.abc_ic_clear_material)
                .into(imageView)
//                .onLoadFailed(error("Error"), Drawable.)
    }
}