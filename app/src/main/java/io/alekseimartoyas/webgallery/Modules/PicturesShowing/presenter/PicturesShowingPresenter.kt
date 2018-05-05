package io.alekseimartoyas.webgallery.Modules.PicturesShowing.presenter

import android.content.Context
import android.widget.ImageView
import io.alekseimartoyas.tradetracker.Foundation.BasePresenter
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor.PicturesShowingInteractorInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor.PicturesShowingInteractorOutput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.router.PicturesShowingRouterInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivityInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivityOutput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapterInput
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapterOutput

class PicturesShowingPresenter: BasePresenter<PicturesShowingActivityInput,
        PicturesShowingInteractorInput,
        PicturesShowingRouterInput>(),
        PicturesShowingActivityOutput,
        PicturesShowingInteractorOutput,
        WebImageGalleryAdapterOutput {

    override var interactor: PicturesShowingInteractorInput? = null
    override var activity: PicturesShowingActivityInput? = null
    override var router: PicturesShowingRouterInput? = null

    var adapter: WebImageGalleryAdapterInput? = null

    override fun getImage(context: Context, imageView: ImageView, url: String)  {
        interactor?.getImage(context, imageView, url)
    }

    override fun getPhotoListAndPushToAdapter(page: Int, perPage: Int) {
        interactor?.getPhotoList(page, perPage)
    }

    override fun pushPhotoListToAdapter(data: MutableList<WebPhoto>) {
        adapter?.addPhotosUrls(data)
    }

    override fun destructor() {
        activity = null
        interactor?.destructor()
        interactor = null
        router = null
        adapter?.destructor()
        adapter = null
    }
}