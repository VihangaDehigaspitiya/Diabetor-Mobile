package org.openmined.syft.demo.profile.edit_profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.ProfileViewModel
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityEditProfileBinding
import org.openmined.syft.demo.databinding.ActivityProfileBinding
import org.openmined.syft.demo.profile.ProfileActivity
import org.openmined.syft.demo.report.ReportActivity

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


        binding.btnCancelUpdate.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }    }
}