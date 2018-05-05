package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.view.PictureDetailedActivity
import io.alekseimartoyas.webgallery.R
import com.bumptech.glide.Glide
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapter.MyViewHolder




class WebImageGalleryAdapter(context: Context):
        RecyclerView.Adapter<WebImageGalleryAdapter.MyViewHolder>(),
        WebImageGalleryAdapterInput {

    private var mSpacePhotos: Array<WebPhoto>? = null
    private var mContext = context
    var presenter: WebImageGalleryAdapterOutput? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebImageGalleryAdapter.MyViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val photoView = inflater.inflate(R.layout.item_image_card, parent, false)
        return MyViewHolder(photoView)
    }

    override fun getItemCount(): Int {
        return mSpacePhotos?.size ?: 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mPhotoImageView: ImageView

        init {
            mPhotoImageView = itemView.findViewById(R.id.iv_photo) as ImageView
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {

            val position = getAdapterPosition()
            if (position != RecyclerView.NO_POSITION) {
                val spacePhoto = mSpacePhotos?.get(position)
                val intent = Intent(mContext, PictureDetailedActivity::class.java)
                intent.putExtra("photo", spacePhoto)
                mContext.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val spacePhoto = mSpacePhotos?.get(position)
        val imageView = holder.mPhotoImageView

//        Glide.with(mContext)
//                .load(spacePhoto?.getUrl())
////                .placeholder(R.drawable.ic_cloud_off_red)
//                .into(imageView)
    }
}