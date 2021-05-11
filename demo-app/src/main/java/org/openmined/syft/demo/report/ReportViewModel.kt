package org.openmined.syft.demo.report

import androidx.lifecycle.ViewModel
import org.openmined.syft.demo.BuildConfig.SYFT_AUTH_TOKEN

class ReportViewModel : ViewModel() {

    fun checkUrl(baseUrl: String): Boolean {
        return true
    }

    fun getAuthToken() : String = SYFT_AUTH_TOKEN
}