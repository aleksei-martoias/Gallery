package io.alekseimartoyas.webgallery.Modules.PictureDetailed.view

import android.graphics.Color
import android.os.Bundle
import android.os.Parcel
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import io.alekseimartoyas.tradetracker.Foundation.BaseActivity
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.configurator.PictureDetailedConfigurator
import io.alekseimartoyas.webgallery.R
import kotlinx.android.synthetic.main.activity_picture_detailed.*

class PictureDetailedActivity : BaseActivity<PictureDetailedActivityOutput>(),
        PictureDetailedActivityInput {
    override var presenter: PictureDetailedActivityOutput? = null

    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_detailed)

        PictureDetailedConfigurator(this).buildModule()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initViews()
        showPhoto(intent.getParcelableExtra("photo"))
    }

    private fun showPhoto(photo: WebPhoto) {
        if (imageView != null && photo.getUrl() != null)
            presenter?.getPicture(this, imageView!!, photo.getUrl()!!)

        if (photo.getProfileUrl() != null)
            presenter?.getPicture(this, profileImage, photo.getProfileUrl()!!)

        createdBy.text = photo.getPublishedBy()
        createdAt.text = photo.getPublishedAt()?.slice(0..9)
        sizes.text = photo.getSize()
    }

    private fun initViews() {
        imageView = image
    }

    override fun destructor() {
        presenter?.destructor()
        presenter = null
        imageView = null
    }

    override fun onDestroy() {
        super.onDestroy()
        destructor()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                presenter?.showPicturesShowing(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
