package com.andi.onlinestore.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.andi.onlinestore.MainActivity
import com.andi.onlinestore.R
import com.andi.onlinestore.helper.ApiRetrofit
import com.andi.onlinestore.helper.SharePref
import com.andi.onlinestore.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private lateinit var s:SharePref
    private lateinit var etEmail:EditText
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button
    private val api by lazy { ApiRetrofit().endPoint }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_login, container, false)
        s= SharePref(requireActivity())

        setupView(view)
        btnLogin.setOnClickListener {
            checkField()

        }




        return view
    }

    private fun checkField() {
        if (etEmail.text.isNullOrEmpty()){
            etEmail.error="data isi dahulu"
        }else if (etPassword.text.isNullOrEmpty()){
            etPassword.error="data isi dahulu"
        }else{
            login()
        }
    }



    private fun login() {
        api.login(etEmail.text.toString(),etPassword.text.toString()).enqueue(object : Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    s.setId(response.body()!!.id)
                    s.setStatusLogin(true)
                    Toast.makeText(context,"Succes Login",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext(),MainActivity::class.java))
                }else{
                    Toast.makeText(context,"Failed respon",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(context,"Failed Login",Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setupView(view: View) {
        etEmail=view.findViewById(R.id.et_email)
        etPassword=view.findViewById(R.id.et_password)
         btnLogin = view.findViewById(R.id.btnlogin)

    }


}