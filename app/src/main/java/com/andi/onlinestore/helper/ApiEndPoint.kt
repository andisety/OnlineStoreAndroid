package com.andi.onlinestore.helper

import com.andi.onlinestore.model.SubmitRespons
import com.andi.onlinestore.model.User
import retrofit2.Call
import retrofit2.http.*

interface ApiEndPoint {

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name")name:String,
        @Field("email")email:String,
        @Field("password")password:String,
        @Field("noHp")noHp:String,
    ):Call<SubmitRespons>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email")email:String,
        @Field("password")password:String,
    ):Call<User>


    @GET("show/{id}")
    fun show(
        @Path("id")id:String?
    ):Call<List<User>>



    @GET("delete/{id}")
    fun destroy(
        @Path("id")id:String
    ):Call<SubmitRespons>

}