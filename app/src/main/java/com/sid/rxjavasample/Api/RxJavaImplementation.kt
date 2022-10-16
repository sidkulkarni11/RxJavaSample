package com.sid.rxjavasample.Api

import android.app.Application
import android.content.Context

class RxJavaImplementation : Application() {
    companion object{
       private lateinit var context : Context

        fun getContext():Context{
            return  context
        }
    }
    override fun onCreate() {
        super.onCreate()

        context = applicationContext

        var dataManager = DataManager.init(context)
        dataManager?.initApiManager()
    }
}