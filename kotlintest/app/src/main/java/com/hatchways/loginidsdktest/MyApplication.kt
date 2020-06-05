package com.hatchways.loginidsdktest

import android.app.Application
import login.api.LoginApi

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        val clientId = BuildConfig.ClientID
        val baseUrl = BuildConfig.BaseURL
        LoginApi.client().configure(this, clientId, baseUrl)
        // Required initialization logic here!
    }
}