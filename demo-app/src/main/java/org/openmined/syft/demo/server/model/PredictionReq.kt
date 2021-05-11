package org.openmined.syft.demo.server.model

import com.google.gson.annotations.SerializedName

data class PredictionReq(

    @SerializedName("gender")
    var gender: String,

    @SerializedName("age")
    var age: Int,

    @SerializedName("creatinineRatio")
    var creatinineRatio: Double,

    @SerializedName("hbA1C")
    var hbA1C: Double,

    @SerializedName("cholesterol")
    var cholesterol: Double,

    @SerializedName("triglycerids")
    var triglycerids: Double,

    @SerializedName("HDL")
    var HDL: Double,

    @SerializedName("LDL")
    var LDL: Double,

    @SerializedName("VLDL")
    var VLDL: Double,

    @SerializedName("BMI")
    var BMI: Double,

    @SerializedName("urea")
    var urea: Double
)