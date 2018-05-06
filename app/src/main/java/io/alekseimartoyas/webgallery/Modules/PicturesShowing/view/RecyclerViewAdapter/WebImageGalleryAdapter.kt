package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.Modules.PictureDetailed.view.PictureDetailedActivity
import io.alekseimartoyas.webgallery.R

class WebImageGalleryAdapter(context: Context):
        RecyclerView.Adapter<WebImageGalleryAdapter.MyViewHolder>(),
        WebImageGalleryAdapterInput {

    private var photos: MutableList<WebPhoto>? = mutableListOf()
    private var mContext: Context? = context
    var presenter: WebImageGalleryAdapterOutput? = null

    override fun addPhotosUrls(data: MutableList<WebPhoto>) {
        photos?.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun deleteData() {
        photos = mutableListOf()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebImageGalleryAdapter.MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val photoView = inflater.inflate(R.layout.item_image_card, parent, false)
        return MyViewHolder(photoView)
    }

    override fun getItemCount(): Int {
        return photos?.size ?: 0
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
                val spacePhoto = photos?.get(position)
                val intent = Intent(mContext, PictureDetailedActivity::class.java)
                intent.putExtra("photo", spacePhoto)
                mContext?.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val spacePhoto = photos?.get(position)
        val imageView = holder.mPhotoImageView

        presenter?.getImage(mContext!!, imageView, spacePhoto?.getUrl() ?: "")
//        Glide.with(mContext)
//                .load(spacePhoto?.getUrl())
////                .placeholder(R.drawable.ic_cloud_off_red)
//                .into(imageView)
    }

    override fun destructor() {
        mContext = null
    }
}