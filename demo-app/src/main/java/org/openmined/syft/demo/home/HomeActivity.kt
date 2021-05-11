package org.openmined.syft.demo.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.R
import org.openmined.syft.demo.bmi.BMIActivity
import org.openmined.syft.demo.databinding.ActivityHomeBinding
import org.openmined.syft.demo.home_profile.HomeProfileActivity
import org.openmined.syft.demo.prediction.PredictionActivity
import org.openmined.syft.demo.profile.ProfileActivity
import org.openmined.syft.demo.report.ReportActivity
import org.openmined.syft.demo.sign_in.SignInActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(HomeViewModel::class.java)

        binding.btnHome.setOnClickListener {
            val intent = Intent(this, HomeProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnPrediction.setOnClickListener {
            val intent = Intent(this, PredictionActivity::class.java)
            startActivity(intent)
        }

        binding.btnReports.setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }

        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnBMI.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogOut.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}