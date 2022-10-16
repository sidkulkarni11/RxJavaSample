package com.sid.rxjavasample.Api

import com.sid.rxjavasample.AllData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("https://gnews.io/api/v4/top-headlines/")
    fun contentResponse(@Query("token") token : String, @Query("lang") lang: String): Observable<AllData>


}