package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

class PaginationOnScrollListener(private var layoutManager: GridLayoutManager?):
        RecyclerView.OnScrollListener(),
        PaginationOnScrollListenerInput {

    var presenter: PaginationOnScrollListenerOutput? = null
    private var loading = false
    private var page = 0
    private var maxPage = 5

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

//        recyclerView?.layoutManager?.find     where is that method
        val lastVisiblePosition = layoutManager?.findLastVisibleItemPosition()

        val count = recyclerView?.adapter?.itemCount ?: 1
        if (lastVisiblePosition == count - 1) {
            1
            if (!loading && page < maxPage) {
                loading = true
                ++page
                presenter?.getPhotoListAndPushToAdapter(page, 20)
            }
        } else
            1
    }

    override fun finishLoading() {
        loading = false
    }

    override fun destructor() {
        layoutManager = null
    }
}