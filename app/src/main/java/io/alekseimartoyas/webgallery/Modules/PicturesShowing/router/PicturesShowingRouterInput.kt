package io.alekseimartoyas.webgallery.Modules.PicturesShowing.router

import android.content.Context
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto

interface PicturesShowingRouterInput {
    fun showDeatailed(photo: WebPhoto, context: Context)
}