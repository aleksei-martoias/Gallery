package io.alekseimartoyas.webgallery.Modules.PicturesShowing.interactor

import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto

interface PicturesShowingInteractorOutput {
    fun pushPhotoListToAdapter(data: MutableList<WebPhoto>)
}