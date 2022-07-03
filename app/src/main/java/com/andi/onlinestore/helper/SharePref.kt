package com.andi.onlinestore.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharePref(activity: Activity) {

    val myPref = "MAIN_PREF"
    val sp:SharedPreferences
    val statusLogin="login"

    init {
        sp=activity.getSharedPreferences(myPref,Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(statusLogin,status).apply()
    }
    fun getStatusLogin():Boolean{
        return sp.getBoolean(statusLogin,false)
    }
}