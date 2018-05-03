package io.alekseimartoyas.webgallery.DataLayer.Entity

import android.os.Parcelable
import android.os.Parcel



class WebPhoto(url: String, title: String): Parcelable {
    private var mUrl: String? = url
    private var mTitle: String? = title

    protected constructor(input: Parcel) : this(input.readString(), input.readString())


    val CREATOR: Parcelable.Creator<WebPhoto> = object : Parcelable.Creator<WebPhoto> {
        override fun createFromParcel(`in`: Parcel): WebPhoto {
            return WebPhoto(`in`)
        }

        override fun newArray(size: Int): Array<WebPhoto?> {
            return arrayOfNulls(size)
        }
    }

    fun getUrl() : String? {
        return mUrl
    }

    fun setUrl(url: String) {
        mUrl = url
    }

    fun getTitle(): String? {
        return mTitle
    }

    fun setTitle(title: String) {
        mTitle = title
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(mUrl)
        p0?.writeString(mTitle)
    }
}