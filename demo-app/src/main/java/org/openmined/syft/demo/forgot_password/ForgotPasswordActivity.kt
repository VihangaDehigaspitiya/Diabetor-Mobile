package org.openmined.syft.demo.forgot_password

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import es.dmoral.toasty.Toasty
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityForgotPasswordBinding
import org.openmined.syft.demo.databinding.ActivitySignInBinding
import org.openmined.syft.demo.home.HomeActivity
import org.openmined.syft.demo.sign_in.SignInActivity
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

        binding.btnRequestLink.setOnClickListener {

            val emailText = findViewById<EditText>(R.id.et_forgot_password_email);
            var email = emailText.text.toString();

            var isValidEmail = email.validEmail();

            if(!isValidEmail) {
                var toast = Toasty.error(applicationContext, "Invalid email address", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show()
            }

            if(isValidEmail){
                var toast = Toasty.success(applicationContext, "Password reset email was successfully sent", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show()

                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }
        }

        binding.btnCancel.setOnClickListener{
            onBackPressed()
        }
    }
}