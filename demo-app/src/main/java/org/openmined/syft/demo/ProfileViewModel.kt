package org.openmined.syft.demo

import androidx.lifecycle.ViewModel
import org.openmined.syft.demo.BuildConfig.SYFT_AUTH_TOKEN

class ProfileViewModel : ViewModel() {

    fun checkUrl(baseUrl: String): Boolean {
        return true
    }

    fun getAuthToken() : String = SYFT_AUTH_TOKEN
}