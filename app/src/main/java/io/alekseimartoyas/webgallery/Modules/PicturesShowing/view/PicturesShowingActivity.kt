package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import io.alekseimartoyas.tradetracker.Foundation.BaseActivity
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.configurator.PicturesShowingConfigurator
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.PaginationOnScrollListener
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapter
import io.alekseimartoyas.webgallery.R
import kotlinx.android.synthetic.main.activity_pictures_showing.*

class PicturesShowingActivity : BaseActivity<PicturesShowingActivityOutput>(),
        PicturesShowingActivityInput {

    override var presenter: PicturesShowingActivityOutput? = null
    var adapter: WebImageGalleryAdapter? = null
    var layoutManager: GridLayoutManager? = null
    var paginationListener: PaginationOnScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictures_showing)

        PicturesShowingConfigurator(this).buildModule()

        val recyclerView = recyclerview_images
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager!!
        recyclerView.addOnScrollListener(paginationListener)

        recyclerView.adapter = adapter!!

        refreshLayout.setOnRefreshListener { presenter?.reloadData(1, 20) }
    }

    override fun onStart() {
        super.onStart()
        presenter?.reloadData(1, 20)
    }

    override fun stopRefreshing() {
        refreshLayout?.isRefreshing = false
    }

    override fun errorToastShow(messageId: Int) = Toast.makeText(this,
            this.getText(messageId),
            Toast.LENGTH_SHORT).show()

    override fun destructor() {
        presenter?.destructor()
        presenter = null
        adapter?.destructor()
        adapter = null
        layoutManager = null
        paginationListener = null
    }

    override fun onDestroy() {
        super.onDestroy()
        destructor()
    }
}
