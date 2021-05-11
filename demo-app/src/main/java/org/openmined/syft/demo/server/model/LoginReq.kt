package org.openmined.syft.demo.server.model

import com.google.gson.annotations.SerializedName

data class LoginReq (
    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String
)