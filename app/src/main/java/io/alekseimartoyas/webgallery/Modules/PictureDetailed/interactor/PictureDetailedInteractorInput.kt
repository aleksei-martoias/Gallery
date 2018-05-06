package io.alekseimartoyas.webgallery.Modules.PictureDetailed.interactor

import android.content.Context
import android.widget.ImageView

interface PictureDetailedInteractorInput {
    fun getPicture(context: Context, imageView: ImageView, url: String)

    fun destructor()
}