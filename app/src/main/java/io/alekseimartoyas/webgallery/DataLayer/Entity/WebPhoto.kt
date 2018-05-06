package io.alekseimartoyas.webgallery.DataLayer.Entity

import android.os.Parcelable
import android.os.Parcel

class WebPhoto(private var url: String? = null,
               private var title: String? = null,
               private var publishedAt: String? = null,
               private var size: String? = null,
               private var publishedBy: String? = null,
               private var id: String? = null,
               private var color: String? = null,
               private var profileUrl: String? = null): Parcelable { // profile photo

    constructor(input: Parcel) : this(input.readString(), input.readString())

    companion object CREATOR : Parcelable.Creator<WebPhoto> {
        override fun createFromParcel(`in`: Parcel): WebPhoto {
            return WebPhoto(`in`)
        }

        override fun newArray(size: Int): Array<WebPhoto?> {
            return arrayOfNulls(size)
        }
    }

    fun getUrl() : String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(url)
        p0?.writeString(title)
    }
}