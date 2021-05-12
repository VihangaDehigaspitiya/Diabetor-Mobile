package org.openmined.syft.demo.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.ProfileViewModel
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityProfileBinding
import org.openmined.syft.demo.profile.edit_profile.EditProfileActivity
import org.openmined.syft.demo.report.ReportActivity

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


        binding.btnEditDetails.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnCancelUpdate2.setOnClickListener {
            onBackPressed()
        }
    }
}