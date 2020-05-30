package com.hatchways.loginidsdksample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_authenticate.*
import login.api.LoginApi
import login.api.LoginCallback
import login.api.RegisterCallback
import login.api.client.LoginResponse
import login.api.client.RegisterResponse

class Authenticate : AuthActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticate)
    }

    val registerCallback = object: RegisterCallback {
        override fun onComplete(response: RegisterResponse) {
            if (response.success) {
                Toast.makeText(this@Authenticate, "Registration complete!", Toast.LENGTH_LONG).show()
                finish()
            }
            else {
                Toast.makeText(this@Authenticate, response.errorMessage, Toast.LENGTH_LONG).show()
            }

        }
    }

    val loginCallback = object: LoginCallback {
        override fun onComplete(response: LoginResponse) {
            if (response.success) {
                Toast.makeText(this@Authenticate, "Login success!", Toast.LENGTH_LONG).show()
                finish()
            }
            else {
                Toast.makeText(this@Authenticate, response.errorMessage, Toast.LENGTH_LONG).show()
            }

        }
    }

    fun login(view: View) {
        if (editUsername.text.toString() == "" || editUsername.text == null) {
            LoginApi.client().login(this, loginCallback)
        }
        else {
            LoginApi.client().login(this, editUsername.text.toString(), loginCallback)
        }

    }

    fun register(view: View) {
        if(editUsername.text.toString() == "" || editUsername.text == null) {
            LoginApi.client().register(this, registerCallback)
        }
        else {
            LoginApi.client().registerWithUsername(this, editUsername.text.toString(), registerCallback)
        }
    }

}
