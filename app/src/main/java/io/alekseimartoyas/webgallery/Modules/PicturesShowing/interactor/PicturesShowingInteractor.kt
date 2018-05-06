package io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor

import android.content.Context
import android.widget.ImageView
import io.alekseimartoyas.tradetracker.Foundation.BaseInteractor
import io.alekseimartoyas.webgallery.R
import io.alekseimartoyas.webgallery.Services.GlideServiceInput
import io.alekseimartoyas.webgallery.Services.UnsplashInput

class PicturesShowingInteractor: BaseInteractor<PicturesShowingInteractorOutput>(),
        PicturesShowingInteractorInput {

    override var presenter: PicturesShowingInteractorOutput? = null
    var unspalsh: UnsplashInput? = null
    var glide: GlideServiceInput? = null

    override fun getPhotoList(page: Int, perPage: Int) {
        unspalsh?.getPhotoList(page, perPage,
                {data -> presenter?.pushPhotoListToAdapter(data)},
                {presenter?.errorToastShow(R.string.network_error)})
    }

    override fun getImage(context: Context, imageView: ImageView, url: String) {
        glide?.getPhoto(context, imageView, url)
    }

    override fun destructor() {
        presenter = null
        unspalsh = null
        glide = null
    }
}