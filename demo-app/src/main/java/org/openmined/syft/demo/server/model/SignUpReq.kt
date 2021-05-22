package org.openmined.syft.demo.server.model;

import com.google.gson.annotations.SerializedName

data class SignUpReq(
    @SerializedName("name")
    var name: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("gender")
    var gender: String,

    @SerializedName("age")
    var age: Int
)
