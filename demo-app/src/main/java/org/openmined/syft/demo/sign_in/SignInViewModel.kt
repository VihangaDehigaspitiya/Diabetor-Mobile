package org.openmined.syft.demo.sign_in

import androidx.lifecycle.ViewModel
import org.openmined.syft.demo.BuildConfig.SYFT_AUTH_TOKEN

class SignInViewModel : ViewModel() {

    fun checkUrl(baseUrl: String): Boolean {
        return true
    }

    fun getAuthToken() : String = SYFT_AUTH_TOKEN
}