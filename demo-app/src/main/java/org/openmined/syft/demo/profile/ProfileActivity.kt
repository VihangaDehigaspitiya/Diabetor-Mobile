package org.openmined.syft.demo.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_home_profile.textView9
import kotlinx.android.synthetic.main.activity_home_profile.txtUserNameTop
import org.openmined.syft.demo.ProfileViewModel
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityProfileBinding
import org.openmined.syft.demo.profile.edit_profile.EditProfileActivity
import org.openmined.syft.demo.report.ReportActivity
import org.openmined.syft.demo.server.model.UserData
import org.openmined.syft.demo.server.service.RestApiService
import java.lang.reflect.Type

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        profileViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProfileViewModel::class.java)

        getUserDetails()
        binding.btnEditDetails.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnCancelUpdate2.setOnClickListener {
            onBackPressed()
        }
    }

    fun getUserDetails() {
        val apiService = RestApiService()
        apiService.getUserData {
            if (it?.status == true) {
                var userDataString = it.value.toString();
                val listType: Type = object : TypeToken<UserData?>() {}.getType()
                var userData: UserData = Gson().fromJson(userDataString, listType)
                val txtName = findViewById<TextView>(R.id.textView9)
                txtName.setText(userData.name);
            } else {
                var toastP = Toasty.error(
                    applicationContext,
                    it?.message.toString(),
                    Toast.LENGTH_SHORT,
                    true
                );
                toastP.setGravity(Gravity.TOP, 0, 25);
                toastP.show()
            }
        }
    }
}