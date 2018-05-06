package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

interface PaginationOnScrollListenerOutput {
    fun getPhotoListAndPushToAdapter(page: Int, perPage: Int)
}