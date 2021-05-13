package org.openmined.syft.demo.report.report_details

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import es.dmoral.toasty.Toasty
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityReportDetailsBinding
import org.openmined.syft.demo.report.ReportActivity
import org.openmined.syft.demo.server.model.PredictionData
import org.openmined.syft.demo.server.model.ReportData
import org.openmined.syft.demo.server.service.RestApiService
import java.lang.reflect.Type

class ReportDetailsActivity : AppCompatActivity() {
    private val sharedPrefFile = "savedData"
    private lateinit var reportDetailsViewModel: ReportDetailsViewModel
    private lateinit var binding: ActivityReportDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_report_details)
        reportDetailsViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ReportDetailsViewModel::class.java)


        binding.btnGoBack.setOnClickListener {
            onBackPressed()
        }

        val id  = intent.getStringExtra("Id")

        getPredictionDetails(id)

    }

    fun getPredictionDetails(id: String){
        val apiService = RestApiService()
        apiService.getPredictionDetails(id) {
            if (it?.status == true) {
                try{
                    var predictionString = it.value.toString();
                    val listType: Type = object : TypeToken<PredictionData>() {}.getType()
                    var predictionDetails: PredictionData = Gson().fromJson(predictionString, listType);
                    val btAge = findViewById<TextView>(R.id.textView38)
                    val btGender = findViewById<TextView>(R.id.textView37)
                    val btCre = findViewById<TextView>(R.id.textView39)
                    val btHbal = findViewById<TextView>(R.id.textView41)
                    val btCol = findViewById<TextView>(R.id.textView40)
                    val btTrigy = findViewById<TextView>(R.id.textView43)
                    val btHdl = findViewById<TextView>(R.id.textView42)
                    val btLdl = findViewById<TextView>(R.id.textView44)
                    val btVldl = findViewById<TextView>(R.id.textView45)
                    val btBmi = findViewById<TextView>(R.id.textView53)
                    val btUrea = findViewById<TextView>(R.id.txtUrea)

                    btAge.setText(predictionDetails.age.toString())
                    btGender.setText(predictionDetails.gender)
                    btBmi.setText(predictionDetails.BMI.toString())
                    btCre.setText(predictionDetails.creatinineRatio.toString())
                    btHbal.setText(predictionDetails.hbA1C.toString())
                    btCol.setText(predictionDetails.cholesterol.toString())
                    btTrigy.setText(predictionDetails.triglycerids.toString())
                    btHdl.setText(predictionDetails.HDL.toString())
                    btLdl.setText(predictionDetails.LDL.toString())
                    btVldl.setText(predictionDetails.VLDL.toString())
                    btUrea.setText(predictionDetails.urea.toString())

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