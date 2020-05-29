package com.hatchways.loginidsdksample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import login.api.LoginApi

//Simple convenience function so that you don't have to redeclare onActivityResult in every activity to include the LoginApi HandleIntent
abstract class AuthActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        LoginApi.client().handleIntentResult(requestCode,resultCode,data)
    }
}