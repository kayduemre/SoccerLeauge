package com.emrekaydu.soccerleauge.app.extensions

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuild {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://ul7wjd5i19.execute-api.us-east-1.amazonaws.com/prod/"

    fun getInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().build())
                .build()

        }
        return retrofit
    }
}