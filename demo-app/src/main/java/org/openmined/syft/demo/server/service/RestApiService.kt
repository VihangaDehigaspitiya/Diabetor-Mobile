package org.openmined.syft.demo.server.service

import org.openmined.syft.demo.server.model.LoginReq
import org.openmined.syft.demo.server.model.PredictionReq
import org.openmined.syft.demo.server.model.SignUpReq
import org.openmined.syft.demo.server.model.UpdateUserReq
import org.openmined.syft.demo.server.model.responseUser
import org.openmined.syft.demo.server.model.testData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {

    fun login(userData: LoginReq, onResult: (responseUser?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.loginUser(userData).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun signup(userData: SignUpReq, onResult: (responseUser?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.signupUser(userData).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun getUserData(onResult: (responseUser?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.getUserData(SessionManager.USER_TOKEN).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun updateUserDetails(userData: UpdateUserReq, onResult: (responseUser?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.updateUserDetails(userData, SessionManager.USER_TOKEN).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun addPrediction(predData: PredictionReq, onResult: (responseUser?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.addPrediction(predData, SessionManager.USER_TOKEN).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun getLatestPrediction(onResult: (responseUser?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.getLatestPrediction(SessionManager.USER_TOKEN).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun getAllPredictions(onResult: (responseUser?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.getAllPredictions(SessionManager.USER_TOKEN).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }

    fun getPredictionDetails(id: String, onResult: (responseUser?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.getPredictionDetails(id, SessionManager.USER_TOKEN).enqueue(
            object : Callback<responseUser> {
                override fun onFailure(call: Call<responseUser>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<responseUser>, response: Response<responseUser>) {
                    if(response != null){
                        var isSuccess = response.body();
                        if (isSuccess != null) {
                            val addedUser = isSuccess
                            onResult(addedUser)
                        }
                    }

                }
            }
        )
    }
}