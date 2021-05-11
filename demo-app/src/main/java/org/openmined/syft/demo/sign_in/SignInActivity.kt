package org.openmined.syft.demo.sign_in

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import es.dmoral.toasty.Toasty
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivitySignInBinding
import org.openmined.syft.demo.forgot_password.ForgotPasswordActivity
import org.openmined.syft.demo.home.HomeActivity
import org.openmined.syft.demo.server.model.LoginReq
import org.openmined.syft.demo.server.model.UserValue
import org.openmined.syft.demo.server.service.RestApiService
import org.openmined.syft.demo.server.service.SessionManager
import org.openmined.syft.demo.signup.SignUpActivity
import java.lang.reflect.Type

class SignInActivity : AppCompatActivity() {
    private val sharedPrefFile = "TOKEN"
    private lateinit var signInViewModel: SignInViewModel
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        /*if(SessionManager.USER_TOKEN != ""){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }else{*/
            binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
            signInViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(SignInViewModel::class.java)

            binding.txtSignUp.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }

            binding.tvForgotPassword.setOnClickListener {
                val intent = Intent(this, ForgotPasswordActivity::class.java)
                startActivity(intent)
            }

            binding.btnSignIn.setOnClickListener {
                //val intent = Intent(this, HomeActivity::class.java)
                //startActivity(intent)
                val emailText = findViewById<EditText>(R.id.tv_email)
                val passwordText = findViewById<EditText>(R.id.et_password)
                var email = emailText.text.toString();
                var password = passwordText.text.toString();

                //var isValid = email.validEmail()  // isValid will be true or false

                var isValidPassword = password.validator().nonEmpty().check();
                var isEmailValid = true;

                if(!isValidPassword){
                    var toastP = Toasty.error(applicationContext, "Password required", Toast.LENGTH_SHORT, true);
                    toastP.setGravity(Gravity.TOP, 0 ,25);
                    toastP.show()
                    return@setOnClickListener
                }

                email.validEmail() {
                    isEmailValid = false
                    var toast = Toasty.error(applicationContext, it, Toast.LENGTH_SHORT, true);
                    toast.setGravity(Gravity.TOP, 0 ,25);
                    toast.show()
                }

                if(isEmailValid && isValidPassword){
                    signInDetails(email, password)
                }
                // Or you can also validate with an error callback method


            }


        //signInDetails()
    }

    @SuppressLint("CommitPrefEdits")
    fun signInDetails(email: String, password: String) {
        val apiService = RestApiService()
        val userinfo = LoginReq (email = email, password = password)
        apiService.login(userinfo) {
            if (it?.status == true) {
                var userDataString = it.value.toString();
                val listType: Type = object : TypeToken<UserValue?>() {}.getType()
                var userData: UserValue = Gson().fromJson(userDataString, listType)
                //userData.
                var token = "Bearer " + userData.token;
                val sessionManager = SessionManager(applicationContext);
                sessionManager.saveAuthToken(token)
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                print(it?.value)
            } else {
                var toastP = Toasty.error(applicationContext, it?.message.toString(), Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
            }
        }
    }

}