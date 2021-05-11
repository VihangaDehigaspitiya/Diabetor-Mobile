package org.openmined.syft.demo.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityBMIBinding
import org.openmined.syft.demo.databinding.ActivityPredictionBinding
import org.openmined.syft.demo.home.HomeActivity
import org.openmined.syft.demo.home_profile.HomeProfileActivity
import org.openmined.syft.demo.prediction.PredictionViewModel

class BMIActivity : AppCompatActivity() {
    private lateinit var bmiViewModel: BMIViewModel
    private lateinit var binding: ActivityBMIBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_b_m_i)
        bmiViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(BMIViewModel::class.java)

        val height = findViewById<EditText>(R.id.editTextNumber)
        val weight = findViewById<EditText>(R.id.editTextNumber2)
        val result = findViewById<EditText>(R.id.editTextNumber3)
        val btgetBmi = findViewById<Button>(R.id.btnGetBmi)
        val btgoBack = findViewById<Button>(R.id.bntCancelBmi)


        btgetBmi.setOnClickListener(View.OnClickListener {
            val heightVal:Double = height.text.toString().toDouble()
            val weightVal:Double = weight.text.toString().toDouble()


            val results: Double = weightVal / (heightVal * heightVal)

            result.setText(results.toString())

            })

        btgoBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })





    }
}

