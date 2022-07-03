package com.andi.onlinestore.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.andi.onlinestore.R

import com.andi.onlinestore.helper.ApiRetrofit
import com.andi.onlinestore.model.SubmitRespons
import com.andi.onlinestore.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private val api by lazy { ApiRetrofit().endPoint }
    lateinit var etName:EditText
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var etNoHp:EditText
    lateinit var btnRegister:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_register, container, false)
        setUpView(view)
        btnRegister.setOnClickListener {
            checkField()
        }

        return view
    }

    private fun setUpView(view: View){
         etName=view.findViewById<EditText>(R.id.et_name)
         etEmail=view.findViewById<EditText>(R.id.et_email)
         etPassword=view.findViewById<EditText>(R.id.et_password)
         etNoHp=view.findViewById<EditText>(R.id.et_noHp)
         btnRegister = view.findViewById<Button>(R.id.btnsignup)
    }

    private fun checkField(){

        if (etName.text.isEmpty()){
            etName.error="isi data dahulu"
        }else if (etEmail.text.isEmpty()){
            etEmail.error="isi data dahulu"
        }else if (etPassword.text.isEmpty()){
            etPassword.error="isi data dahulu"
        }else if (etNoHp.text.isEmpty()){
            etNoHp.error="isi data dahulu"
        }else{
            Log.e("Create User","Start Create User")
            registerUser()
        }
    }

    private fun registerUser() {
        api.register(
            etName.text.toString(),
            etEmail.text.toString(),
            etPassword.text.toString(),
            etNoHp.text.toString()
        ).enqueue(object: Callback<SubmitRespons>{
            override fun onResponse(call: Call<SubmitRespons>, response: Response<SubmitRespons>) {
                if (response.isSuccessful){
                    val fm = requireActivity().supportFragmentManager
                    val fragmentLogin = LoginFragment()
                    val result = response.body()!!.message
                    Toast.makeText(requireContext(),result, Toast.LENGTH_SHORT).show()
                    fm.beginTransaction().replace(R.id.container_login,fragmentLogin)
                        .addToBackStack(null)
                        .commit()
                }else
                    Toast.makeText(requireContext(),"signup failed", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<SubmitRespons>, t: Throwable) {
                Toast.makeText(requireContext(),"signup failed", Toast.LENGTH_SHORT).show()
            }

        })
    }


}