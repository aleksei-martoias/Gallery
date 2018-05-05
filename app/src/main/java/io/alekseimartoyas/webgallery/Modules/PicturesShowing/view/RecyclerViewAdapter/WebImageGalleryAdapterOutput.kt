package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

import android.content.Context
import android.widget.ImageView

interface WebImageGalleryAdapterOutput {
    fun getImage(context: Context, imageView: ImageView, url: String)

    fun getPhotoListAndPushToAdapter(page: Int, perPage: Int)
}