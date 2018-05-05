package io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor

import io.alekseimartoyas.tradetracker.Foundation.BaseInteractor
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivityOutput
import io.alekseimartoyas.webgallery.Services.GlideServiceInput
import io.alekseimartoyas.webgallery.Services.UnsplashInput

class PicturesShowingInteractor: BaseInteractor<PicturesShowingActivityOutput>(),
        PicturesShowingInteractorInput {
    override var presenter: PicturesShowingActivityOutput? = null

    var unspalsh: UnsplashInput? = null
    var glide: GlideServiceInput? = null

    override fun destructor() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}