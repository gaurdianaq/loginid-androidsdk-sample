package com.hatchways.loginidsdksample

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_authenticate.*
import login.api.LoginCallback
import login.api.RegisterCallback
import login.api.client.LoginResponse
import login.api.client.RegisterResponse

class Authenticate : AuthActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticate)
        setSupportActionBar(toolbar)
    }

    val registerCallback = object: RegisterCallback {
        override fun onComplete(response: RegisterResponse) {

        }
    }

    val loginCallback = object: LoginCallback {
        override fun onComplete(response: LoginResponse) {

        }
    }

}
