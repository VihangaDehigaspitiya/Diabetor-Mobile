package org.openmined.syft.demo.prediction

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.os.Handler
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wajahatkarim3.easyvalidation.core.collection_ktx.validNumberList
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import es.dmoral.toasty.Toasty
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityPredictionBinding
import org.openmined.syft.demo.home.HomeActivity
import org.openmined.syft.demo.home_profile.HomeProfileActivity
import org.openmined.syft.demo.server.model.LoginReq
import org.openmined.syft.demo.server.model.PredictionReq
import org.openmined.syft.demo.server.model.UserValue
import org.openmined.syft.demo.server.service.RestApiService
import org.openmined.syft.demo.server.service.SessionManager
import java.lang.reflect.Type

class PredictionActivity : AppCompatActivity() {
    private val sharedPrefFile = "savedData"
    private lateinit var predictionViewModel: PredictionViewModel
    private lateinit var binding: ActivityPredictionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_prediction)
        predictionViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(PredictionViewModel::class.java)


        val txtAge = findViewById<EditText>(R.id.etAge)
        val txtGender = findViewById<EditText>(R.id.etGender)
        val txtUrea = findViewById<EditText>(R.id.etUrea)
        val txtCre = findViewById<EditText>(R.id.etCre)
        val txtHbAlc = findViewById<EditText>(R.id.etAbl)
        val txtChols = findViewById<EditText>(R.id.etCholest)
        val txtTrigy = findViewById<EditText>(R.id.etTrigly)
        val txthdl = findViewById<EditText>(R.id.etHDL)
        val txtLdl = findViewById<EditText>(R.id.etLdl)
        val txtVldl = findViewById<EditText>(R.id.etVldd)
        val txtBmi = findViewById<EditText>(R.id.etBmi)


        val btProceed = findViewById<Button>(R.id.button2)
        val sharedPreferences: SharedPreferences =
                this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar5)

        progressBar.isVisible = false

        btProceed.setOnClickListener(View.OnClickListener {
            val age: String = txtAge.text.toString()
            val gender: String = txtGender.text.toString()
            val urea: String = txtUrea.text.toString()
            val crea: String = txtCre.text.toString()
            val hba1c: String = txtHbAlc.text.toString()
            val cholos: String = txtChols.text.toString()
            val trigy: String = txtTrigy.text.toString()
            val hdl: String = txthdl.text.toString()
            val ldl: String = txtLdl.text.toString()
            val vldl: String = txtVldl.text.toString()
            val bmi: String = txtBmi.text.toString()



            val isValidAge = age.validator().check();
            val isValidGender = gender.validator().check();
            val isValidUrea = urea.validator().check();
            val isValidCrea = crea.validator().check();
            val isValidHba1c = hba1c.validator().check();
            val isValidCholos = cholos.validator().check();
            val isValidTrigy = trigy.validator().check();
            val isValidHdl = hdl.validator().check();
            val isValidLdl = ldl.validator().check();
            val isValidVldl = vldl.validator().check();
            val isValidBmi = bmi.validator().check();

            if(!isValidAge){
                var toastP = Toasty.error(applicationContext, "Invalid age", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidUrea){
                var toastP = Toasty.error(applicationContext, "Invalid Urea Value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidGender){
                var toastP = Toasty.error(applicationContext, "Invalid gender", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidCrea){
                var toastP = Toasty.error(applicationContext, "Invalid crea value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidHba1c){
                var toastP = Toasty.error(applicationContext, "Invalid hba1c value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidCholos){
                var toastP = Toasty.error(applicationContext, "Invalid cholesterol value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidTrigy){
                var toastP = Toasty.error(applicationContext, "Invalid triglycerides value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidHdl){
                var toastP = Toasty.error(applicationContext, "Invalid hdl value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidLdl){
                var toastP = Toasty.error(applicationContext, "Invalid ldl value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidVldl){
                var toastP = Toasty.error(applicationContext, "Invalid vldl value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidBmi){
                var toastP = Toasty.error(applicationContext, "Invalid bmi value", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(isValidAge && isValidGender && isValidCrea && isValidHba1c && isValidCholos && isValidTrigy && isValidHdl && isValidLdl && isValidVldl
               && isValidBmi){
                progressBar.isVisible = true
                val predictionData = PredictionReq(gender, Integer.parseInt(age), crea.toDouble(), hba1c.toDouble(), cholos.toDouble(),
                    trigy.toDouble(), hdl.toDouble(), ldl.toDouble(), vldl.toDouble(), bmi.toDouble(), 10.0
                )
                Handler().postDelayed({
                    progressBar.isVisible = false
                   addPrediction(predictionData)

                }, 10000)
            }

//            val editor: SharedPreferences.Editor = sharedPreferences.edit()
//            editor.putString("age", age)
//            editor.putString("gender", gender)
//            editor.putString("crea", crea)
//            editor.putString("hbalc", hba1c)
//            editor.putString("cholos", cholos)
//            editor.putString("trigy", trigy)
//            editor.putString("hdl", hdl)
//            editor.putString("ldl", ldl)
//            editor.putString("vldl",vldl)
//            editor.putString("bmi",bmi)
//            editor.apply()
//            editor.commit()



        })


        binding.btnCancel.setOnClickListener{
            onBackPressed()
        }

    }

    fun addPrediction(predReq: PredictionReq){
        val apiService = RestApiService()
        apiService.addPrediction(predReq) {
            if (it?.status == true) {
                val intent = Intent(this, HomeProfileActivity::class.java)
                startActivity(intent)
            } else {
                var toastP = Toasty.error(applicationContext, it?.message.toString(), Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
            }
        }
    }
}