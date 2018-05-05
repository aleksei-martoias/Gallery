package io.alekseimartoyas.webgallery.Modules.PictureDetailed.configurator

import io.alekseimartoyas.webgallery.Modules.PictureDetailed.interactor.PictureDetailedInteractor
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.presenter.PictureDetailedPresenter
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.router.PictureDetailedRouter
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.view.PictureDetailedActivity
import io.alekseimartoyas.webgallery.MyApp

class PictureDetailedConfigurator(private var context: PictureDetailedActivity?) {

    fun buildModule() {
        val presenter = PictureDetailedPresenter()
        val interactor = PictureDetailedInteractor()
        val router = PictureDetailedRouter()

        context?.presenter = presenter

        presenter.activity = context
        presenter.interactor = interactor
        presenter.router = router



        interactor.presenter = presenter
        interactor.glide = MyApp.graph.getGlide()

        context = null
    }
}