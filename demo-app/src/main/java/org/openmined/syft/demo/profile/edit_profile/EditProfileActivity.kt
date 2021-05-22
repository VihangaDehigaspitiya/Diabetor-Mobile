package org.openmined.syft.demo.profile.edit_profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import es.dmoral.toasty.Toasty
import org.openmined.syft.demo.ProfileViewModel
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityEditProfileBinding
import org.openmined.syft.demo.databinding.ActivityProfileBinding
import org.openmined.syft.demo.profile.ProfileActivity
import org.openmined.syft.demo.report.ReportActivity
import org.openmined.syft.demo.server.model.SignUpReq
import org.openmined.syft.demo.server.model.UpdateUserReq
import org.openmined.syft.demo.server.service.RestApiService
import org.openmined.syft.demo.sign_in.SignInActivity

class EditProfileActivity : AppCompatActivity() {
    private lateinit var editProfileViewModel: EditProfileViewModel
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile)
        editProfileViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(EditProfileViewModel::class.java)

        //val name  = intent.getStringExtra("name")
        //val age  = intent.getStringExtra("age")

        val nameText = findViewById<EditText>(R.id.et_first_name2)
        val ageText = findViewById<EditText>(R.id.et_first_name4)

        //nameText.setText(name);
       // ageText.setText(age);

        binding.btnCancelUpdate.setOnClickListener {
            onBackPressed()
        }

        binding.btnUpdateDetails.setOnClickListener {



            var name = nameText.text.toString();
            var age = ageText.text.toString();

            var isValidName = name.validator().nonEmpty().check();
            var isValidAge = age.validator().nonEmpty().validNumber().check();

            if(!isValidName){
                var toast = Toasty.error(applicationContext, "Name is required", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@setOnClickListener;
            }

            if(!isValidAge){
                var toast = Toasty.error(applicationContext, "Age is required", Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
                return@setOnClickListener;
            }

            if(isValidName && isValidAge){
                //val intent = Intent(this, SignInActivity::class.java)
                //startActivity(intent)
                var ageInt = Integer.parseInt(age)
                updateUser(ageInt, name)
            }
        }
    }

    fun updateUser(age: Int, name: String){
        val apiService = RestApiService()
        var user = UpdateUserReq(age, name)
        apiService.updateUserDetails(user) {
            if (it?.status == true) {
                var toast = Toasty.success(applicationContext, it?.message.toString(), Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
            } else {
                var toast = Toasty.error(applicationContext, it?.message.toString(), Toast.LENGTH_SHORT, true);
                toast.setGravity(Gravity.TOP, 0 ,25);
                toast.show();
            }
        }
    }
}