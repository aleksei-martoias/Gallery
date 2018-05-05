package io.alekseimartoyas.webgallery.Services

import io.alekseimartoyas.webgallery.NetworkLayer.RetrofitManagerInputOutput
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface UnsplashInput {
    fun getPhotoList(page: Int, perPage: Int)
}

class Unsplash(private val retrofitService: RetrofitManagerInputOutput?,
               private val clientId: String) : UnsplashInput {

    override fun getPhotoList(page: Int, perPage: Int) {
        retrofitService!!.getPhotosList(page, perPage, clientId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                ?.flatMap { parse(it) }
                ?.subscribe({success -> println(success)},
                        {error -> error.printStackTrace()})
    }

    fun parse(it: Any): Observable<Any> {


        return Observable.just(Any())
    }
}