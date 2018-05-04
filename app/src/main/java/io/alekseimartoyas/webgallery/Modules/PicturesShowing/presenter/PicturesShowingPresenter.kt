package io.alekseimartoyas.webgallery.Modules.PicturesShowing.presenter

import io.alekseimartoyas.tradetracker.Foundation.BasePresenter
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor.PicturesShowingInteractorInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor.PicturesShowingInteractorOutput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.router.PicturesShowingRouterInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivityInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivityOutput

class PicturesShowingPresenter: BasePresenter<PicturesShowingActivityInput,
        PicturesShowingInteractorInput,
        PicturesShowingRouterInput>(),
        PicturesShowingActivityOutput,
        PicturesShowingInteractorOutput {

    override var interactor: PicturesShowingInteractorInput? = null
    override var activity: PicturesShowingActivityInput? = null
    override var router: PicturesShowingRouterInput? = null

    override fun destructor() {
        activity = null
        interactor?.destructor()
        interactor = null
        router = null
    }
}