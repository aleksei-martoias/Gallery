package io.alekseimartoyas.webgallery.Modules.PictureDetailed.view

import android.content.Context
import android.widget.ImageView

interface PictureDetailedActivityOutput {
    fun showPicturesShowing(context: Context)

    fun getPicture(context: Context, imageView: ImageView, url: String)

    fun destructor()
}