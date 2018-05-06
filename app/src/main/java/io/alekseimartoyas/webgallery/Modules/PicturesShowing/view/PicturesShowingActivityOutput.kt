package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view

interface PicturesShowingActivityOutput {
    fun getPhotoListAndPushToAdapter(page: Int, perPage: Int)

    fun reloadData(page: Int, perPage: Int)

    fun destructor()
}