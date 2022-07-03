package com.andi.onlinestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.andi.onlinestore.R

class ProsesLoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.activity_proses_login, container, false)

        val fm = requireActivity().supportFragmentManager
        val prosesLoginFragment = ProsesLoginFragment()
        val loginFragment = LoginFragment()
        val registerFragment = RegisterFragment()

        val btnProsesLogin = view.findViewById<Button>(R.id.btn_proses_login)
        val btnProsesRegister = view.findViewById<Button>(R.id.btn_proses_daftar)

        btnProsesLogin.setOnClickListener{
            fm.beginTransaction().replace(R.id.container_login,loginFragment)
                .addToBackStack(null)
                .commit()

        }
        btnProsesRegister.setOnClickListener {
            fm.beginTransaction().replace(R.id.container_login,registerFragment)
                .addToBackStack(null)
                .commit()
        }
            return view
    }


}