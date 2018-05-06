package io.alekseimartoyas.webgallery.Modules.PicturesShowing.configurator

import android.support.v7.widget.GridLayoutManager
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor.PicturesShowingInteractor
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.presenter.PicturesShowingPresenter
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.router.PicturesShowingRouter
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.PicturesShowingActivity
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.PaginationOnScrollListener
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapter
import io.alekseimartoyas.webgallery.MyApp

class PicturesShowingConfigurator(private var context: PicturesShowingActivity?) {

    fun buildModule() {
        val presenter = PicturesShowingPresenter()
        val interactor = PicturesShowingInteractor()
        val router = PicturesShowingRouter()
        val adapter =  WebImageGalleryAdapter(context!!)
        val layoutManager = GridLayoutManager(context,2)
        val paginator = PaginationOnScrollListener(layoutManager)

        context?.presenter = presenter
        context?.adapter = adapter
        context?.layoutManager = layoutManager
        context?.paginationListener = paginator

        adapter?.presenter = presenter
        paginator?.presenter = presenter

        presenter.activity = context
        presenter.interactor = interactor
        presenter.router = router
        presenter.adapter = adapter
        presenter.paginator = paginator

        interactor.presenter = presenter
        interactor.unspalsh = MyApp.graph.getUnsplash()
        interactor.glide = MyApp.graph.getGlide()

        context = null
    }
}