package com.andi.onlinestore.helper

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRetrofit {

    val endPoint:ApiEndPoint
        get() {
            val inteceptor=HttpLoggingInterceptor()
            inteceptor.level=HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(inteceptor)
                .build()

            val retrofit=Retrofit.Builder()
                .baseUrl("http://192.168.0.111:8000/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiEndPoint::class.java)
        }
}