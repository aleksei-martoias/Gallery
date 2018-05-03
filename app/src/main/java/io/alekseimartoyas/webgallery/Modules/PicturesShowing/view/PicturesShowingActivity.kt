package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapter
import io.alekseimartoyas.webgallery.R
import kotlinx.android.synthetic.main.activity_pictures_showing.*

class PicturesShowingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictures_showing)

        val layoutManager = GridLayoutManager(this,2)
        val recyclerView = rv_images
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        val adapter = WebImageGalleryAdapter(this, arrayOf<WebPhoto>(
                WebPhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                WebPhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                WebPhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                WebPhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                WebPhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                WebPhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite")))

        recyclerView.adapter = adapter
    }
}
