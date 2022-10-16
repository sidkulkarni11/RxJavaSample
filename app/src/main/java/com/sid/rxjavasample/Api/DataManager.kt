package com.sid.rxjavasample.Api

import android.content.Context
import com.sid.rxjavasample.AllData
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import java.util.ArrayList

class DataManager private constructor(context: Context) {
    var context: Context
    private var apiManager: ApiManager? = null
    fun initApiManager() {
        apiManager = ApiManager.getInstance()
    }
    companion object {
        private var instance: DataManager? = null

        fun getInstance(): DataManager? {
            checkNotNull(instance) { "Call init() before getInstance()" }
            return instance
        }

        @Synchronized
        fun init(context: Context): DataManager? {
            if (instance == null) {
                instance = DataManager(context)
            }
            return instance
        }
    }

    fun contentResponse(token: String, lang : String) : Observable<AllData> {
        return apiManager!!.contentResponse(token,lang)
    }


    init {
        this.context = context
    }
}