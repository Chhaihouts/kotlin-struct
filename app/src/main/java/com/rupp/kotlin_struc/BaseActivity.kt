package com.rupp.kotlin_struc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rupp.kotlin_struc.Api.ApiModelHelper
import com.rupp.kotlin_struc.Model.BaseModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseActivity: AppCompatActivity() {
    private var disposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disposable = CompositeDisposable()
    }

//    fun <T>callApi(api: Observable<BaseModel<T>>, onNext:((t:BaseModel<T>) -> Unit), onError:((t:Throwable) -> Unit)): Disposable {
//        val apiObservable = ApiModelHelper.observe(api).subscribe(onNext,onError)
//        addDisposable(apiObservable)
//        return apiObservable
//    }

    fun <T>callApi(api: Observable<T>, onNext:((t:T) -> Unit), onError:((t:Throwable) -> Unit)): Disposable {
        val apiObservable = ApiModelHelper.observe(api).subscribe(onNext,onError)
        addDisposable(apiObservable)
        return apiObservable
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.clear()
    }

    private  fun addDisposable(d: Disposable) {
        disposable?.add(d)
    }
}