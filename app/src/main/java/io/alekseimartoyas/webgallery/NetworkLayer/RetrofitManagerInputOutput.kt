package io.alekseimartoyas.webgallery.NetworkLayer

import com.google.gson.internal.LinkedTreeMap
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitManagerInputOutput {
    @GET("search/collections")
    fun getSearchPhotosList(@Query("page") page: Int,
                    @Query("query") query: String,
                    @Query("per_page") perPage: Int,
                    @Query("client_id") clientId: String) : Observable<Any>

    @GET("photos")
    fun getPhotosList(@Query("page") page: Int,
                      @Query("per_page") perPage: Int,
                      @Query("client_id") clientId: String) : Observable<Any>
//            Observable<ArrayList<LinkedTreeMap<String,LinkedTreeMap<String,String>>>?>
}