package com.hatchways.loginidsdksample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_authenticated.*
import login.api.LoginApi

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AuthenticatedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authenticated, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        authenticatedMsg.text = getString(R.string.authenticated_message, LoginApi.client().currentUsername)
    }

}
