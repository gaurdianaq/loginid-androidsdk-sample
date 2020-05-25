package com.hatchways.loginidsdksample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import io.loginid.api.LoginidApi
import io.loginid.api.LoginidRegisterCallback
import io.loginid.api.model.client.RegisterResponse

class MainActivity : AppCompatActivity() {

    lateinit var mytext: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginidApi.client().configure(this,"hRhrUIW0XGSRycDTFNvpy-CyJTdICfm5k5rmP5XI59Y7fZU67N2HkC1THx7g87Nfzv3v1585PH6R5DhIhKHkIQ==", "https://768ffe70-9dd3-11ea-8f78-0ba1ae20e4c1.sandbox-apse1.native-api.loginid.io")

        mytext = findViewById(R.id.mytext)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // register handle intent result from Android biometrics and such
        LoginidApi.client().handleIntentResult(requestCode,resultCode,data)
    }

    val registerCallback = LoginidRegisterCallback { response ->
        if (response.success) {
            mytext.text = "Successfully registered gaurdianaq"
        }
        else {
            mytext.text = "Did not successfully register"
        }
    }

    fun registerCallBack2(registerResponse: RegisterResponse) {

    }

    fun register(view: View) {
        LoginidApi.client().registerWithUsername(this, "gaurdianaq") { registerResponse -> println("we did a thing!") }
    }

}
