package org.openmined.syft.demo.server.model

import java.text.DecimalFormat

data class PredictionData (
    val id: String,
    val gender: String,
    val age: Int,
    val creatinineRatio: Double,
    val hbA1C: Double,
    val cholesterol: Double,
    val triglycerids: Double,
    val HDL: Double,
    val LDL: Double,
    val VLDL: Double,
    val BMI: Double,
    val urea: Double,
    val prediction: Boolean
    )