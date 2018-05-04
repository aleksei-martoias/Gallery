package io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor

import io.alekseimartoyas.tradetracker.Foundation.BaseInteractor
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivityOutput

class PicturesShowingInteractor: BaseInteractor<PicturesShowingActivityOutput>(),
        PicturesShowingInteractorInput {
    override var presenter: PicturesShowingActivityOutput? = null

    override fun destructor() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}