package org.openmined.syft.demo.server.service

import org.openmined.syft.demo.server.model.LoginReq
import org.openmined.syft.demo.server.model.SignUpReq
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

    /*fun getUserData(onResult: (testData?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(ApiService::class.java)
        retrofit.getUserData(SessionManager.USER_TOKEN).enqueue(
            object : Callback<testData> {
                override fun onFailure(call: Call<testData>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<testData>, response: Response<testData>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )

    }*/
}