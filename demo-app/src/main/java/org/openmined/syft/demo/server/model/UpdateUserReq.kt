package org.openmined.syft.demo.server.model

import com.google.gson.annotations.SerializedName

data class UpdateUserReq (
    @SerializedName("age")
    var age: Int,

    @SerializedName("name")
    var name: String
)