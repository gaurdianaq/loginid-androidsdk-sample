package com.hatchways.loginidsdksample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import login.api.LoginApi
import login.api.LoginCallback
import login.api.RegisterCallback
import login.api.client.RegisterResponse

class MainActivity : AuthActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        if (LoginApi.client().isLoggedIn) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, AuthenticatedFragment()).commit()
            authenticate_btn.text = getString(R.string.authenticate_button_message)
        }
        else {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, UnauthenticatedFragment()).commit()
            authenticate_btn.text = getString(R.string.logout_button_message)
        }
    }

    fun authenticate(view: View) {
        val authenticateIntent = Intent(this, Authenticate::class.java)
        startActivity(authenticateIntent)
    }
}
