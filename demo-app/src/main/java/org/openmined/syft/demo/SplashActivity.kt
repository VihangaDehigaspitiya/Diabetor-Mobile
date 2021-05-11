package org.openmined.syft.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.openmined.syft.demo.sign_in.SignInActivity

class SplashActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}