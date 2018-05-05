package io.alekseimartoyas.webgallery.Modules.PictureDetailed.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import io.alekseimartoyas.tradetracker.Foundation.BaseActivity
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.configurator.PictureDetailedConfigurator
import io.alekseimartoyas.webgallery.R
import kotlinx.android.synthetic.main.activity_picture_detailed.*

class PictureDetailedActivity : BaseActivity<PictureDetailedActivityO>(),
        PictureDetailedActivityInput {
    override var presenter: PictureDetailedActivityO? = null

    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detailed)

        PictureDetailedConfigurator(this).buildModule()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun destructor() {
        presenter?.destructor()
        presenter = null
    }

    override fun onDestroy() {
        super.onDestroy()
        destructor()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
        // Respond to the action bar's Up/Home button
            android.R.id.home -> {
                onNavigateUp()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
