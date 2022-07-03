package com.andi.onlinestore.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.andi.onlinestore.MainActivity
import com.andi.onlinestore.R
import com.andi.onlinestore.helper.SharePref

class LoginFragment : Fragment() {
    private lateinit var s:SharePref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_login, container, false)
        val btnLogin = view.findViewById<Button>(R.id.btnlogin)
        s= SharePref(requireActivity())

        btnLogin.setOnClickListener {
            s.setStatusLogin(true)
            startActivity(Intent(requireContext(),MainActivity::class.java))
        }
        return view
    }


}