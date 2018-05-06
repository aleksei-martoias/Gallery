package io.alekseimartoyas.webgallery.Modules.PicturesShowing.router

import android.content.Context
import android.content.Intent
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.view.PictureDetailedActivity

class PicturesShowingRouter: PicturesShowingRouterInput {
    override fun showDeatailed(photo: WebPhoto, context: Context) {
        val intent = Intent(context, PictureDetailedActivity::class.java)
        intent.putExtra("photo", photo)
        context.startActivity(intent)
    }
}