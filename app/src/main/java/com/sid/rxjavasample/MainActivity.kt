package com.sid.rxjavasample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    lateinit var appViewModel: AppViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appViewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)

        appViewModel.getAllData("e034a1cd538e1bbfb0394ad232d93fb3", "en")

        appViewModel.allDataMutableLiveData.observe(
            this, Observer {
        //Expected output
                if (it != null) {
                    if(it.articlelist!=null) {
                        for (art in it.articlelist!!) {
                            Log.d("**soln", art.title)
                            Toast.makeText(this, art.title, Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else{

                }
                /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    it.articlelist.stream().forEach {
                        if (it != null)
                            Log.d("**Solution**", " Title : " + it.title)
                    }
                }*/
            }
        )
    }
}