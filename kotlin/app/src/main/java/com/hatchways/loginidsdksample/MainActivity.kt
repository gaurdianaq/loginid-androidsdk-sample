package com.hatchways.loginidsdksample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        if (LoginApi.client().hasAccount()) {
            deleteBtn.visibility = View.VISIBLE
        }
        else {
            deleteBtn.visibility = View.INVISIBLE
        }
        if (LoginApi.client().isLoggedIn) {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, AuthenticatedFragment()).commit()
            authenticate_btn.text = getString(R.string.logout_button_message)
            authenticate_btn.setOnClickListener {
                LoginApi.client().logout()
                Toast.makeText(this, "Logged out!", Toast.LENGTH_LONG).show()
                finish()
                startActivity(intent)
            }
        }
        else {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, UnauthenticatedFragment()).commit()
            authenticate_btn.text = getString(R.string.authenticate_button_message)
            authenticate_btn.setOnClickListener {
                val authenticateIntent = Intent(this, Authenticate::class.java)
                startActivity(authenticateIntent)
            }
        }
    }

    fun deleteAccount(view: View) {
        Toast.makeText(this, "DELETED!", Toast.LENGTH_LONG).show()
        LoginApi.client().deleteAccount()
        finish()
        startActivity(intent)
    }
}
