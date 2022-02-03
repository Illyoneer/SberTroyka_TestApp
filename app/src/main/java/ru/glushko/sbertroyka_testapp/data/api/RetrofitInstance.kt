package ru.glushko.sbertroyka_testapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofitInstance by lazy {
        Retrofit.Builder()
            .baseUrl("https://devapp.mosmetro.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val DATA_API: DataAPIService by lazy {
        retrofitInstance.create(DataAPIService::class.java)
    }
}