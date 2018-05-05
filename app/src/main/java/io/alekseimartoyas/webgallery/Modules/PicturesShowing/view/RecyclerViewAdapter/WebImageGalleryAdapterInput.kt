package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto

interface WebImageGalleryAdapterInput {
    fun addPhotosUrls(data: MutableList<WebPhoto>)

    fun destructor()
}