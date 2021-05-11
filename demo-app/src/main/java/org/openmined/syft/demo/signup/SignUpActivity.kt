package org.openmined.syft.demo.signup

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
import org.openmined.syft.demo.databinding.ActivityLoginBinding
import org.openmined.syft.demo.databinding.ActivitySignInBinding
import org.openmined.syft.demo.databinding.ActivitySignUpBinding
import org.openmined.syft.demo.login.LoginViewModel
import org.openmined.syft.demo.report.report_details.ReportDetailsActivity
import org.openmined.syft.demo.server.model.LoginReq
import org.openmined.syft.demo.server.model.SignUpReq
import org.openmined.syft.demo.server.service.RestApiService
import org.openmined.syft.demo.sign_in.SignInActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpViewModel: SignUpViewModel
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        signUpViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(SignUpViewModel::class.java)

        binding.btnCancel.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignUp.setOnClickListener {
            val emailText = findViewById<EditText>(R.id.tv_email)
            val passwordText = findViewById<EditText>(R.id.et_password)
            val confirmPasswordText = findViewById<EditText>(R.id.et_confirm_password)
            val nameText = findViewById<EditText>(R.id.et_first_name)

            var email = emailText.text.toString();
            var password = passwordText.text.toString();
            var confirmPassword = confirmPasswordText.text.toString();
            var name = nameText.text.toString();

            var isEmailValid = true;
            var isValidPassword = password.validator().nonEmpty().check();
            var isValidConfirmPassword = confirmPassword.validator().nonEmpty().check();
            var isValidName = name.validator().nonEmpty().check();


            if(!isValidName){
                var toast = Toasty.error(applicationContext, "Name is required", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@setOnClickListener;
            }

            if(!isValidPassword){
                var toast = Toasty.error(applicationContext, "Password is required", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@setOnClickListener;
            }

            if(!isValidConfirmPassword){
                var toast = Toasty.error(applicationContext, "Confirm Password is required", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@setOnClickListener;
            }

            if(password != confirmPassword){
                var toast = Toasty.error(applicationContext, "Password and Confirm Password does not match", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@setOnClickListener;
            }

            email.validEmail() {
                isEmailValid = false
                var toast = Toasty.error(applicationContext, it, Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@validEmail;
            }

            if(isEmailValid && isValidConfirmPassword && isValidName && isValidPassword){
                //val intent = Intent(this, SignInActivity::class.java)
                //startActivity(intent)
                signUpDetails(email, password, name)
            }

        }
    }

    fun signUpDetails(email: String, password: String, name: String) {
        val apiService = RestApiService()
        val userinfo = SignUpReq (email = email, password = password, name = name)
        apiService.signup(userinfo) {
            if (it?.status == true) {
                var toast = Toasty.success(applicationContext, it?.message.toString(), Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();

                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                // it = newly added user parsed as response
                // it?.id = newly added user ID
                print(it?.value)
            } else {
                var toast = Toasty.error(applicationContext, it?.message.toString(), Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
            }
        }
    }
}