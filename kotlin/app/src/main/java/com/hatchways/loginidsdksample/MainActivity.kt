package com.hatchways.loginidsdksample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import login.api.LoginApi
import login.api.LoginCallback
import login.api.RegisterCallback

const val clientId = "IYFdqXZYo2ryFXNxDFCLrEqONWOTk-QrxVOIzvwJ_D_iJxRMlmUCBiXXGxPthFBP4B906jZCnXQ7TfcF7ykveQ=="
const val baseUrl = "https://a4a49f60-9edb-11ea-b43f-93aac17785e0.sandbox.native-api.auth.asliri.id"

class MainActivity : AppCompatActivity() {
    lateinit var mytext: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginApi.client().configure(this, clientId, baseUrl)

        mytext = findViewById(R.id.mytext)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // register handle intent result from Android biometrics and such
        LoginApi.client().handleIntentResult(requestCode,resultCode,data)
    }

    val registerCallback = RegisterCallback { response ->
        if (response.success) {
            mytext.text = "Successfully registered"
        }
        else {
            mytext.text = "Did not successfully register: ${response.errorMessage}"
        }
    }


    val loginCallback = LoginCallback { loginResponse ->
        if (loginResponse.success) {
            mytext.text = "Successfully logged in!"
        }
        else {
            mytext.text = loginResponse.errorMessage
        }
    }

    fun register(view: View) {
        LoginApi.client().register(this, registerCallback)
    }

    fun hasAccount(view: View) {
        if (LoginApi.client().hasAccount()) {
            mytext.text = "You have an account!"
        }
        else {
            mytext.text = "You do not have an account, click register to create one!"
        }
    }

    fun deleteAccount(view: View) {
        if (LoginApi.client().deleteAccount()) {
            mytext.text = "Delete successful!"
        }
        else {
            mytext.text = "Delete failed!"
        }
    }

    fun login(view: View) {
        LoginApi.client().login(this, loginCallback)
    }

}
