package org.openmined.syft.demo.forgot_password

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityForgotPasswordBinding
import org.openmined.syft.demo.databinding.ActivitySignInBinding
import org.openmined.syft.demo.sign_in.SignInViewModel

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var forgotPasswordViewModel: ForgotPasswordViewModel
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)
        forgotPasswordViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ForgotPasswordViewModel::class.java)
    }
}