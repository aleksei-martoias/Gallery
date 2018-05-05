package io.alekseimartoyas.webgallery.NetworkLayer

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager(baseUrl: String) {
    private var retrofitService: RetrofitManagerInputOutput? = null

    init {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()

        retrofitService = retrofit.create(RetrofitManagerInputOutput::class.java)
    }

    fun getRetrofit(): RetrofitManagerInputOutput? {
        return retrofitService
    }
}