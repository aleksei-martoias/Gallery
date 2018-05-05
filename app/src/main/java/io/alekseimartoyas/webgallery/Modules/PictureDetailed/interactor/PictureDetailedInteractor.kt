package io.alekseimartoyas.webgallery.Modules.PictureDetailed.interactor

import io.alekseimartoyas.tradetracker.Foundation.BaseInteractor
import io.alekseimartoyas.webgallery.Services.GlideServiceInput

class PictureDetailedInteractor: BaseInteractor<PictureDetailedInteractorOutput>(),
        PictureDetailedInteractorInput {
    override var presenter: PictureDetailedInteractorOutput? = null
    var glide: GlideServiceInput? = null

    override fun destructor() {
        glide = null
        presenter = null
    }
}