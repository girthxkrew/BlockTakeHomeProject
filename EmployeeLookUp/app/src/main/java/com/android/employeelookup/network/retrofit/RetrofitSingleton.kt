package com.android.employeelookup.network.retrofit

import com.android.employeelookup.network.interceptor.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    private const val BASE_URL = "https://s3.amazonaws.com"

    private val retrofitSingleton : Retrofit.Builder by lazy {
        val okHttpClient : OkHttpClient.Builder = OkHttpClient().newBuilder().addInterceptor(NetworkConnectionInterceptor())
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val employeeAPI: EmployeeAPI by lazy {
        retrofitSingleton
            .build()
            .create(EmployeeAPI::class.java)
    }
}