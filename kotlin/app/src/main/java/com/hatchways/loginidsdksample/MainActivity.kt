package com.hatchways.loginidsdksample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import login.api.LoginApi
import login.api.LoginCallback
import login.api.RegisterCallback
import login.api.client.RegisterResponse

class MainActivity : AppCompatActivity() {
    lateinit var mytext: TextView
    lateinit var username: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mytext = findViewById(R.id.mytext)
        username = findViewById(R.id.editText)

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

    val registerCallback2 = object: RegisterCallback {
        override fun onComplete(response: RegisterResponse) {
            if (response.success) {
                mytext.text = "Successfully registered"
            }
            else {
                mytext.text = "Did not successfully register ${editText.text}: ${response.errorMessage}"
            }
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
        LoginApi.client().registerWithUsername(this, editText.text.toString(), registerCallback2)
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
        LoginApi.client().login(this@MainActivity, editText.text.toString(), loginCallback)
    }

    fun isLoggedIn(view: View) {
        if (LoginApi.client().isLoggedIn) {
            mytext.text = "You're logged in!"
        }
        else {
            mytext.text = "You're not logged in!"
        }
    }

    fun logOut(view: View) {
        LoginApi.client().logout()
    }
}
