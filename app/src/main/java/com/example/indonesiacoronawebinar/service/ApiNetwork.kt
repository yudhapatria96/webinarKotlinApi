package com.example.indonesiacoronawebinar.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiNetwork {

    var baseUrl = "https://api.kawalcorona.com/"
//    var baseUrl= "http://newsapi.org/v2/"
    fun connectApi(): ApiService {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val client: OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

}