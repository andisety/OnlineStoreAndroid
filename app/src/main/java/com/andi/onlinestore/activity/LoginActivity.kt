package com.andi.onlinestore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andi.onlinestore.R
import com.andi.onlinestore.databinding.ActivityLoginBinding
import com.andi.onlinestore.fragment.LoginFragment
import com.andi.onlinestore.fragment.ProsesLoginFragment
import com.andi.onlinestore.fragment.RegisterFragment
import com.andi.onlinestore.helper.SharePref

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    lateinit var s:SharePref
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        s= SharePref(this)

//        binding.btnProsesLogin.setOnClickListener {
//            s.setStatusLogin(true)
//            startActivity(Intent(this,MainActivity::class.java)
//                .putExtra("login",true))
//        }


        val fm = supportFragmentManager
        val prosesLoginFragment = ProsesLoginFragment()
        val loginFragment = LoginFragment()
        val registerFragment = RegisterFragment()

        fm.beginTransaction().add(R.id.container_login,prosesLoginFragment).show(prosesLoginFragment).commit()

    }
}