package org.openmined.syft.demo.server.service

import android.content.Context
import android.content.SharedPreferences
import org.openmined.syft.demo.server.host.Constants
import org.openmined.syft.demo.server.model.LoginReq
import org.openmined.syft.demo.server.model.LoginResponse
import org.openmined.syft.demo.server.model.PredictionReq
import org.openmined.syft.demo.server.model.SignUpReq
import org.openmined.syft.demo.server.model.responseUser
import org.openmined.syft.demo.server.model.testData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginReq): Call<LoginResponse>

    @POST("/user/login")
    fun loginUser(@Body request: LoginReq): Call<responseUser>

    @POST("/user/register")
    fun signupUser(@Body request: SignUpReq): Call<responseUser>

    @GET("/user/me")
    fun getUserData (@Header("Authorization") token: String): Call<responseUser>

    @GET("/prediction/latest/one")
    fun getLatestPrediction (@Header("Authorization") token: String): Call<responseUser>

    @GET("/prediction")
    fun getAllPredictions (@Header("Authorization") token: String): Call<responseUser>

    @POST("/prediction")
    fun addPrediction (@Body request: PredictionReq, @Header("Authorization") token: String): Call<responseUser>

    @GET("/prediction/{id}")
    fun getPredictionDetails (@Path(value = "id", encoded = false) key: String, @Header("Authorization") token: String): Call<responseUser>

}