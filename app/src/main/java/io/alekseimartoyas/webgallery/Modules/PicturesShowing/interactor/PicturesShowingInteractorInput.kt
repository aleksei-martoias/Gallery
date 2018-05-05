package io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor

import android.content.Context
import android.widget.ImageView

interface PicturesShowingInteractorInput {
    fun getImage(context: Context, imageView: ImageView, url: String)

    fun getPhotoList(page: Int, perPage: Int)

    fun destructor()
}