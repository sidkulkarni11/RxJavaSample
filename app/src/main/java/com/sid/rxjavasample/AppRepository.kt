package com.sid.rxjavasample

import com.sid.rxjavasample.Api.DataManager
import io.reactivex.rxjava3.core.Observable


class AppRepository {
    fun getAllData(
        token: String,
        lang: String
    ): Observable<AllData> {
        return DataManager.getInstance()!!.contentResponse(token, lang)

    }



}