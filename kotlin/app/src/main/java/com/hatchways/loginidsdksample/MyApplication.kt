package com.hatchways.loginidsdksample

import android.app.Application
import login.api.LoginApi

class MyApplication : Application() {
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    override fun onCreate() {
        super.onCreate()
        val clientId = "IYFdqXZYo2ryFXNxDFCLrEqONWOTk-QrxVOIzvwJ_D_iJxRMlmUCBiXXGxPthFBP4B906jZCnXQ7TfcF7ykveQ=="
        val baseUrl = "https://a4a49f60-9edb-11ea-b43f-93aac17785e0.sandbox.native-api.auth.asliri.id"
        LoginApi.client().configure(this, clientId, baseUrl)
        // Required initialization logic here!
    }

}