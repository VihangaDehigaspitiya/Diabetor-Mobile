package org.openmined.syft.demo.report.report_details

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityReportDetailsBinding
import org.openmined.syft.demo.report.ReportActivity

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


        btAge.setText(age.toString())
        btGender.setText(gender.toString())
        btBmi.setText(bmi.toString())
        btCre.setText(crea.toString())
        btHbal.setText(hbalc.toString())
        btCol.setText(cholos.toString())
        btTrigy.setText(trigy.toString())
        btHdl.setText(hdl.toString())
        btLdl.setText(ldl.toString())
        btVldl.setText(vldl.toString())
    }
}