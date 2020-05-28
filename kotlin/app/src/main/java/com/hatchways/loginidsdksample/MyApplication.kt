package com.hatchways.loginidsdksample

import android.app.Application
import login.api.LoginApi

class MyApplication : Application() {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    override fun onCreate() {
        super.onCreate()
        val clientId = BuildConfig.ClientID
        val baseUrl = BuildConfig.BaseURL
        LoginApi.client().configure(this, clientId, baseUrl)
        // Required initialization logic here!
    }

}