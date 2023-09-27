package com.devcation.agtm.network

import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager

object RetrofitInstance {
//    https://velog.io/@jeongminji4490/Android-CookieJar
    val BASE_URL = "https://agtm-back.onrender.com/"

    var builder = OkHttpClient().newBuilder()

    //로그인 후 쿠키정보 사용하도록 csrftoken
    var okHttpClient = builder
        .cookieJar(JavaNetCookieJar(CookieManager()))
        .build()

    val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance() : Retrofit {
        return client
    }
}