package org.openmined.syft.demo.home_profile

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_home_profile.textView9
import kotlinx.android.synthetic.main.activity_home_profile.txtUserNameTop
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityHomeProfileBinding
import org.openmined.syft.demo.server.model.PredictionData
import org.openmined.syft.demo.server.model.UserData
import org.openmined.syft.demo.server.service.RestApiService
import java.lang.reflect.Type

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

        binding.btnCancelUpdate.setOnClickListener {
            onBackPressed()
        }

        getUserDetails();
        getLatestPrediction();
        val progressBar = findViewById<ProgressBar>(R.id.progressBar3)
        progressBar.isVisible = false

        /*val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
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
        val txtType = findViewById<TextView>(R.id.txtType)*/


       /* Handler().postDelayed({
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

        }, 3000)*/
        /*btAge.isVisible = false
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
        btVldl.setText("VLDL \n "+vldl.toString())*/








    }

    fun getUserDetails() {
        val apiService = RestApiService()
        apiService.getUserData {
            if (it?.status == true) {
                var userDataString = it.value.toString();
                val listType: Type = object : TypeToken<UserData?>() {}.getType()
                var userData: UserData = Gson().fromJson(userDataString, listType)
                txtUserNameTop.setText(userData.name);
                textView9.setText(userData.name)
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

    fun getLatestPrediction() {
        val apiService = RestApiService()
        apiService.getLatestPrediction {
            if (it?.status == true) {
                try {
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


                        var latestPredictionDataString = it.value.toString();
                        val listType: Type = object : TypeToken<PredictionData>() {}.getType()
                        var latestPrediction = Gson().fromJson<PredictionData>(
                            latestPredictionDataString,
                            listType
                        )
                        if (latestPrediction != null) {
                            btAge.setText("Age \n " + latestPrediction.age.toString())
                            btGender.setText("Gender \n " + latestPrediction.gender)
                            btBmi.setText("BMI \n " + latestPrediction.BMI.toString())
                            btCre.setText("Creatinine Ratio \n" + latestPrediction.creatinineRatio.toString())
                            btHbal.setText("HBA1C \n " + latestPrediction.hbA1C.toString())
                            btCol.setText("Cholesterol \n " + latestPrediction.cholesterol.toString())
                            btTrigy.setText("Triglycerides \n" + latestPrediction.triglycerids.toString())
                            btHdl.setText("HDL \n " + latestPrediction.HDL.toString())
                            btLdl.setText("LDL \n " + latestPrediction.LDL.toString())
                            btVldl.setText("VLDL \n " + latestPrediction.VLDL.toString())

                            txtGlucoseLevel.setText(latestPrediction.hbA1C.toString())
                            if (latestPrediction.prediction) {
                                txtDiabetesResult.setText("Positive")
                            } else {
                                txtDiabetesResult.setText("Negative")
                            }


                            if (latestPrediction.hbA1C < 6.0) {
                                txtType.setText("Normal")
                            } else if (latestPrediction.hbA1C >= 6.0 && latestPrediction.hbA1C <= 6.4) {
                                txtType.setText("Prediabetes")
                            } else {
                                txtType.setText("Diabetes")
                            }
                        }

                }catch (e: Exception){
                    print(e)
                }


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