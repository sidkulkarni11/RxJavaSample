package com.sid.rxjavasample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class AppViewModel : ViewModel() {

    var appRepository : AppRepository
    var allDataMutableLiveData : MutableLiveData<AllData>

    init {
        appRepository = AppRepository()
        allDataMutableLiveData =MutableLiveData<AllData>()
    }

    fun getAllData(token : String ,lang : String){
        var response = appRepository.getAllData(token, lang)
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getAllDataObserver())
    }
    fun getAllDataObserver(): DisposableObserver<AllData> {
            return object : DisposableObserver<AllData>(){
                override fun onNext(t: AllData) {
                    allDataMutableLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    allDataMutableLiveData.postValue(null)
                }

                override fun onComplete() {

                }

            }
    }

}