package io.alekseimartoyas.webgallery.Services

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.alekseimartoyas.webgallery.R


interface GlideServiceInput {
    fun getPhotoDetailed(context: Context, imageView: ImageView, url: String)
    fun getPhotoCrop(context: Context, imageView: ImageView, url: String)
}

class GlideService : GlideServiceInput {
    override fun getPhotoCrop(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .error(R.drawable.ic_error_grey_24dp)
                .placeholder(R.drawable.ic_cloud_download_grey_24dp)
                .centerCrop()
                .into(imageView)
    }

    override fun getPhotoDetailed(context: Context, imageView: ImageView, url: String) {
        Glide.with(context)
                .load(url)
                .error(R.drawable.ic_error_grey_24dp)
//                .asBitmap()
                .placeholder(R.drawable.ic_cloud_download_grey_24dp)
                .fitCenter()
                .into(imageView)
    }
}