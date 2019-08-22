package com.rupp.kotlin_struc.Model


data class BaseModel<T>(var success:Boolean,var code:Int,var message:String,var result:T)

data class User(var userId: String?, var id: String?, var title: String?, var body: String?)