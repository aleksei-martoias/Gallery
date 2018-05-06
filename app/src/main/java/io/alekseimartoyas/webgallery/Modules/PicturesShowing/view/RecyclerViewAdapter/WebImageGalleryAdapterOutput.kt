package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

import android.content.Context
import android.widget.ImageView
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto

interface WebImageGalleryAdapterOutput {
    fun getImage(context: Context, imageView: ImageView, url: String)

    fun showDetailed(photo: WebPhoto?, context: Context)
}