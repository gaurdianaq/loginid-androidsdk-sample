package com.hatchways.loginidsdktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import login.api.LoginApi
import login.api.LoginCallback
import login.api.RegisterCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        LoginApi.client().handleIntentResult(requestCode,resultCode,data)
    }

    val loginCallback = LoginCallback { loginResponse ->
        if (loginResponse.success) {
            output.text = getString(R.string.loginSuccessMsg)
        }
        else {
            output.text = loginResponse.errorMessage
        }
    }

    val registerCallback = RegisterCallback {registerResponse ->
        if (registerResponse.success) {
            output.text = getString(R.string.registerSuccessMsg)
        }
        else {
            output.text = registerResponse.errorMessage
        }
    }

    fun register(view: View) {
        LoginApi.client().register(this, registerCallback)
    }

    fun registerWithUsername(view: View) {
        LoginApi.client().registerWithUsername(this, userName.text.toString(), registerCallback)
    }

    fun login(view: View) {
        LoginApi.client().login(this, loginCallback)
    }

    fun loginWithUsername(view: View) {
        LoginApi.client().login(this, userName.text.toString(), loginCallback)
    }

    fun hasAccount(view: View) {
        output.text = LoginApi.client().hasAccount().toString()
    }

    fun isLoggedIn(view: View) {
        output.text = LoginApi.client().isLoggedIn.toString()
    }

    fun getUsername(view: View) {
        output.text = LoginApi.client().currentUsername
    }

    fun getToken(view: View) {
        output.text = LoginApi.client().currentAccessToken
    }

    fun logout(view: View) {
        LoginApi.client().logout()
    }

    fun deleteAccount(view: View) {
        output.text = LoginApi.client().deleteAccount().toString()
    }
}
