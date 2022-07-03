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
import com.andi.onlinestore.activity.LoginActivity
import com.andi.onlinestore.helper.SharePref

class AkunFragment : Fragment() {
    lateinit var s:SharePref
   private lateinit var btnLogout:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout=view.findViewById(R.id.btn_logout)
        s= SharePref(requireActivity())

        btnLogout.setOnClickListener{
            s.setStatusLogin(false)
            startActivity(Intent(activity,LoginActivity::class.java))

        }

        return view
    }


}