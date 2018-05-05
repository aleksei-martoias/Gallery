package io.alekseimartoyas.webgallery.Services

import com.google.gson.internal.LinkedTreeMap
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.NetworkLayer.RetrofitManagerInputOutput
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface UnsplashInput {
    fun getPhotoList(page: Int, perPage: Int, push: (data: MutableList<WebPhoto>) -> Unit)
}

class Unsplash(private val retrofitService: RetrofitManagerInputOutput?,
               private val clientId: String) : UnsplashInput {

    override fun getPhotoList(page: Int, perPage: Int, push: (data: MutableList<WebPhoto>) -> Unit) {
        retrofitService!!.getPhotosList(page, perPage, clientId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                ?.flatMap { parse(it) }
                ?.subscribe({success -> push(success)},
                        {error -> error.printStackTrace()})
    }

    fun parse(data: Any): Observable<MutableList<WebPhoto>> {
        val parsedData = mutableListOf<WebPhoto>()
        for (photo in data as ArrayList<Any>) {
            val photoList = photo as LinkedTreeMap<Any,Any>
//            val photoDetailed = (photoList["urls"] as LinkedTreeMap<String, String>)["full"]
            parsedData.add(WebPhoto((photoList["urls"] as LinkedTreeMap<String, String>)["small"]!!, ""))
        }

        return Observable.just(parsedData)
    }
}