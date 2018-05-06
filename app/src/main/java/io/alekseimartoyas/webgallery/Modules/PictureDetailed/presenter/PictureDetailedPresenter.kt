package io.alekseimartoyas.webgallery.Modules.PictureDetailed.presenter

import android.content.Context
import android.widget.ImageView
import io.alekseimartoyas.tradetracker.Foundation.BasePresenter
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.interactor.PictureDetailedInteractorInput
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.interactor.PictureDetailedInteractorOutput
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.router.PictureDetailedRouterInput
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.view.PictureDetailedActivityInput
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.view.PictureDetailedActivityOutput

class PictureDetailedPresenter: BasePresenter<PictureDetailedActivityInput,
        PictureDetailedInteractorInput,
        PictureDetailedRouterInput>(),
        PictureDetailedActivityOutput,
        PictureDetailedInteractorOutput {

    override var interactor: PictureDetailedInteractorInput? = null
    override var activity: PictureDetailedActivityInput? = null
    override var router: PictureDetailedRouterInput? = null

    override fun showPicturesShowing(context: Context) {
        router?.showPicturesShowing(context)
    }

    override fun getPicture(context: Context, imageView: ImageView, url: String) {
        interactor?.getPicture(context, imageView, url)
    }

    override fun destructor() {
        interactor?.destructor()
        interactor = null
        activity = null
        router= null
    }
}