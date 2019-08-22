package com.rupp.kotlin_struc.Api

import com.rupp.kotlin_struc.Constant.Constant
import com.rupp.kotlin_struc.Model.BaseModel
import com.rupp.kotlin_struc.Model.User
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RequestInterface {
    companion object {
        val requestInterface = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RequestInterface::class.java)
    }

    @GET("posts")
    fun getUser(): Observable<List<User>>
}