package io.alekseimartoyas.webgallery.Modules.PictureDetailed.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.R
import kotlinx.android.synthetic.main.activity_picture_detailed.*

class PictureDetailedActivity : AppCompatActivity() {

    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detailed)

        initViews()

        val webPhoto = intent.getParcelableExtra<WebPhoto>("photo")

        Glide.with(this)
                .load(webPhoto.getUrl())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView)
    }

    private fun initViews() {
        imageView = image
    }
}
