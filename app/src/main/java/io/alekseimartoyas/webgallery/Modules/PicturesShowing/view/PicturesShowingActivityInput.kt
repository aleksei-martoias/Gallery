package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view

interface PicturesShowingActivityInput {
    fun errorToastShow(messageId: Int)

    fun stopRefreshing()
}