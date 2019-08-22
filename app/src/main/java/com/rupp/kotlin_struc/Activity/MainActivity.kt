package com.rupp.kotlin_struc.Activity

import android.os.Bundle
import android.util.Log
import com.rupp.kotlin_struc.Api.RequestInterface
import com.rupp.kotlin_struc.BaseActivity
import com.rupp.kotlin_struc.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApi(RequestInterface.requestInterface.getUser(), {
            response -> Log.d("ooooo", response.toString())
        }, {
            error -> Log.d("ooooo", error.toString())
        })
    }
}
