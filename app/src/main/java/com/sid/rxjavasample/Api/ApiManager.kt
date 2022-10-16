package com.sid.rxjavasample.Api

import com.google.gson.GsonBuilder
import com.sid.rxjavasample.AllData
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiManager {
     var apiClient: ApiInterface

    private constructor() {
        this.apiClient = getRetrofitService()
    }


    companion object {
        private var instance = ApiManager()

        fun getInstance(): ApiManager {
            return instance
        }
    }

    fun getRetrofitService(): ApiInterface {
        var httpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        var client = httpClient.build()

        var gson = GsonBuilder()
            .setLenient()
            .create()

        var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://gnews.io/api/v4/top-headlines/")
            .client(client)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        return retrofit.create()
    }

    fun contentResponse(token: String, lang : String) : Observable<AllData> {
       return apiClient.contentResponse(token,lang)
    }
}