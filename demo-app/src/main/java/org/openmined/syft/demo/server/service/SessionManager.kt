package org.openmined.syft.demo.server.service

import android.content.Context
import android.content.SharedPreferences
import org.openmined.syft.demo.R

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN_KEY = "user_token"
        var USER_TOKEN = ""
    }

    /**
     * Function to save auth token
     */
    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN_KEY, token)
        editor.apply()

        fetchAuthToken();
    }

    /**
     * Function to fetch auth token
     */
     fun fetchAuthToken() {
        var token = prefs.getString(USER_TOKEN_KEY, null);
        if (token != null) {
            USER_TOKEN = token
        };
    }
}