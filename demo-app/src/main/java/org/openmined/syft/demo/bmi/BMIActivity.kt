package org.openmined.syft.demo.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wajahatkarim3.easyvalidation.core.view_ktx.validNumber
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import es.dmoral.toasty.Toasty
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
            val heightVal = height.text.toString()
            val weightVal = weight.text.toString()

           val isValidHeight = heightVal.validator().validNumber().nonEmpty().check()
           val isValidWeight = weightVal.validator().validNumber().nonEmpty().check()

            if(!isValidHeight){
                var toastP = Toasty.error(applicationContext, "Invalid height", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(!isValidWeight){
                var toastP = Toasty.error(applicationContext, "Invalid weight", Toast.LENGTH_SHORT, true);
                toastP.setGravity(Gravity.TOP, 0 ,25);
                toastP.show()
                return@OnClickListener
            }

            if(isValidHeight && isValidWeight){
                val results: Double = weightVal.toDouble() / (heightVal.toDouble() * heightVal.toDouble())
                result.setText(results.toString())
            }

            })

        btgoBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })





    }
}

