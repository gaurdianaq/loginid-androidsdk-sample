package com.hatchways.loginidsdksample

import android.app.Application
import login.api.LoginApi

class MyApplication : Application() {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    override fun onCreate() {
        super.onCreate()
        System.getenv()
        val clientId = System.getenv("LOGINIDCLIENTID")
        val baseUrl = System.getProperty("LOGINIDBASEURL")
        LoginApi.client().configure(this, clientId, baseUrl)
        // Required initialization logic here!
    }

}