package io.alekseimartoyas.webgallery.Modules.PictureDetailed.interactor

import android.content.Context
import android.widget.ImageView
import io.alekseimartoyas.tradetracker.Foundation.BaseInteractor
import io.alekseimartoyas.webgallery.Services.GlideServiceInput

class PictureDetailedInteractor: BaseInteractor<PictureDetailedInteractorOutput>(),
        PictureDetailedInteractorInput {

    override var presenter: PictureDetailedInteractorOutput? = null
    var glide: GlideServiceInput? = null

    override fun getPicture(context: Context, imageView: ImageView, url: String) {
        glide?.getPhotoDetailed(context, imageView, url)
    }

    override fun destructor() {
        glide = null
        presenter = null
    }
}