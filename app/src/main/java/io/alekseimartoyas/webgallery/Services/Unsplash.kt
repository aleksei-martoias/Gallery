package io.alekseimartoyas.webgallery.Services

import com.google.gson.internal.LinkedTreeMap
import io.alekseimartoyas.webgallery.DataLayer.Entity.WebPhoto
import io.alekseimartoyas.webgallery.NetworkLayer.RetrofitManagerInputOutput
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface UnsplashInput {
    fun getPhotoList(page: Int, perPage: Int,
                     push: (data: MutableList<WebPhoto>) -> Unit,
                     error: () -> Unit)
}

class Unsplash(private val retrofitService: RetrofitManagerInputOutput?,
               private val clientId: String) : UnsplashInput {

    override fun getPhotoList(page: Int, perPage: Int,
                              push: (data: MutableList<WebPhoto>) -> Unit,
                              error: () -> Unit) {
        retrofitService!!.getPhotosList(page, perPage, clientId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                ?.flatMap { parse(it) }
                ?.subscribe({success -> push(success)},
                        {errorMessage ->
                            errorMessage.printStackTrace()
                            error()
                        })
    }

    fun parse(data: Any): Observable<MutableList<WebPhoto>> {
        val parsedData = mutableListOf<WebPhoto>()
        for (photo in data as ArrayList<Any>) {
            val photoList = photo as LinkedTreeMap<Any,Any>
//            val photoDetailed = (photoList["urls"] as LinkedTreeMap<String, String>)["full"]
            parsedData.add(WebPhoto((photoList["urls"] as LinkedTreeMap<String, String>)["small"]!!,
                    "",
                    photoList["created_at"] as String,
                    "${(photoList["width"] as Double).toInt()}x${(photoList["height"] as Double).toInt()}",
                    (photoList["user"] as LinkedTreeMap<String, String>)["username"] as String,
                    photoList["id"] as String,
                    photoList["color"] as String,
                    ((photoList["user"] as LinkedTreeMap<String, String>)["profile_image"]!!
                            as LinkedTreeMap <String, String>)["medium"]!!))
        }

        return Observable.just(parsedData)
    }
}