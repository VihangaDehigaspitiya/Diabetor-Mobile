package org.openmined.syft.demo.home_profile

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityHomeBinding
import org.openmined.syft.demo.databinding.ActivityHomeProfileBinding
import org.openmined.syft.demo.home.HomeViewModel

class HomeProfileActivity : AppCompatActivity() {
    private val sharedPrefFile = "savedData"
    private lateinit var homeProfileViewModel: HomeProfileViewModel
    private lateinit var binding: ActivityHomeProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_profile)
        homeProfileViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(HomeProfileViewModel::class.java)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val age = sharedPreferences.getInt("age",0)
        val gender = sharedPreferences.getString("gender","defaultname")
        val crea = sharedPreferences.getString("crea","defaultname")
        val hbalc = sharedPreferences.getString("hbalc","defaultname")
        val cholos = sharedPreferences.getString("cholos","defaultname")
        val trigy = sharedPreferences.getString("trigy","defaultname")
        val hdl = sharedPreferences.getString("hdl","defaultname")
        val ldl = sharedPreferences.getString("ldl","defaultname")
        val vldl = sharedPreferences.getString("vldl","defaultname")
        val bmi = sharedPreferences.getString("bmi","defaultname")

        val btAge = findViewById<Button>(R.id.btnAge)
        val btGender = findViewById<Button>(R.id.btnGen)
        val btCre = findViewById<Button>(R.id.btnCre)
        val btHbal = findViewById<Button>(R.id.btnHbalc)
        val btCol = findViewById<Button>(R.id.btnCol)
        val btTrigy = findViewById<Button>(R.id.btnTrigy)
        val btHdl = findViewById<Button>(R.id.btnHdl)
        val btLdl = findViewById<Button>(R.id.btnLdl)
        val btVldl = findViewById<Button>(R.id.btnVldl)
        val btBmi = findViewById<Button>(R.id.btBmi)


        val txtGlucoseLevel = findViewById<TextView>(R.id.txtGlucoseLevel)
        val txtDiabetesResult = findViewById<TextView>(R.id.txtDiabetesResult)
        val txtType = findViewById<TextView>(R.id.txtType)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar3)

        Handler().postDelayed({
            btAge.isVisible = true
            btGender.isVisible = true
            btCre.isVisible = true
            btHbal.isVisible = true
            btCol.isVisible = true
            btTrigy.isVisible = true
            btHdl.isVisible = true
            btLdl.isVisible = true
            btVldl.isVisible = true
            btBmi.isVisible = true
            txtGlucoseLevel.isVisible = true
            txtDiabetesResult.isVisible = true
            txtType.isVisible = true
            progressBar.isVisible = false

        }, 3000)
        btAge.isVisible = false
        btGender.isVisible = false
        btCre.isVisible = false
        btHbal.isVisible = false
        btCol.isVisible = false
        btTrigy.isVisible = false
        btHdl.isVisible = false
        btLdl.isVisible = false
        btVldl.isVisible = false
        btBmi.isVisible = false
        txtGlucoseLevel.isVisible = false
        txtDiabetesResult.isVisible = false
        txtType.isVisible = false

        btAge.setText("Age \n "+age.toString())
        btGender.setText("Gender \n "+gender.toString())
        btBmi.setText("BMI \n "+bmi.toString())
        btCre.setText("Creatinine Ratio \n"+crea.toString())
        btHbal.setText("HBAL \n "+hbalc.toString())
        btCol.setText("Cholesterol \n "+cholos.toString())
        btTrigy.setText("Triglycerides \n"+trigy.toString())
        btHdl.setText("HDL \n "+hdl.toString())
        btLdl.setText("LDL \n "+ldl.toString())
        btVldl.setText("VLDL \n "+vldl.toString())



        txtGlucoseLevel.setText("45")
        txtDiabetesResult.setText("Positive")
        txtType.setText("Prediabetes")


    }
}