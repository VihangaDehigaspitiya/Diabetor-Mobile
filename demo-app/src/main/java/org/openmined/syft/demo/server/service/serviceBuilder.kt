package org.openmined.syft.demo.server.service

import okhttp3.OkHttpClient
import org.openmined.syft.demo.server.host.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) // change this IP for testing by your actual machine IP
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}