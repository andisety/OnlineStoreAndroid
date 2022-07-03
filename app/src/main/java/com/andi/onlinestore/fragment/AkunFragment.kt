package com.andi.onlinestore.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.andi.onlinestore.R
import com.andi.onlinestore.activity.LoginActivity
import com.andi.onlinestore.helper.ApiRetrofit
import com.andi.onlinestore.helper.SharePref
import com.andi.onlinestore.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AkunFragment : Fragment() {
    private lateinit var s:SharePref
   private lateinit var btnLogout:Button
   private lateinit var tvName:TextView
   private lateinit var tvEmail:TextView
   private lateinit var tvNohp:TextView
   private val api by lazy { ApiRetrofit().endPoint }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_akun, container, false)

        s= SharePref(requireActivity())

        setupView(view)



        btnLogout.setOnClickListener{
            s.setStatusLogin(false)
            s.setId("")
            startActivity(Intent(activity,LoginActivity::class.java))

        }

        return view
    }

    private fun setupView(view: View) {
        tvName=view.findViewById(R.id.tv_name)
        tvEmail=view.findViewById(R.id.tv_email)
        tvNohp=view.findViewById(R.id.tv_noHp)
        btnLogout=view.findViewById(R.id.btn_logout)

        api.show(s.getId()).enqueue(object:Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    Log.e("get user","respons berhasil")
                    tvName.text = "Name : "+ response.body()!![0].name
                    tvEmail.text = "Email: "+ response.body()!![0].email
                    tvNohp.text = "No Hp : "+response.body()!![0].noHp
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(context,t.message,Toast.LENGTH_SHORT).show()
                Log.e("get user",t.message!!)
            }

        })

    }





}