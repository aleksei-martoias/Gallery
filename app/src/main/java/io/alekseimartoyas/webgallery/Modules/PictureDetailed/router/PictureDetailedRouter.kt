package io.alekseimartoyas.webgallery.Modules.PictureDetailed.router

import android.content.Context
import android.content.Intent
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivity

class PictureDetailedRouter: PictureDetailedRouterInput {
    override fun showPicturesShowing(context: Context) {
        val intent = Intent(context, PicturesShowingActivity::class.java)
        context.startActivity(intent)
    }
}