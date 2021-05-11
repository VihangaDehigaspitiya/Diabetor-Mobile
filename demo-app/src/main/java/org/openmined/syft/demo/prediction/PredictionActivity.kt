package org.openmined.syft.demo.prediction

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityPredictionBinding
import org.openmined.syft.demo.home_profile.HomeProfileActivity

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

        btProceed.setOnClickListener(View.OnClickListener {
            val age: Int = Integer.parseInt(txtAge.text.toString())
            val gender: String = txtGender.text.toString()
            val crea: String = txtCre.text.toString()
            val hbalc: String = txtHbAlc.text.toString()
            val cholos: String = txtChols.text.toString()
            val trigy: String = txtTrigy.text.toString()
            val hdl: String = txthdl.text.toString()
            val ldl: String = txtLdl.text.toString()
            val vldl: String = txtVldl.text.toString()
            val bmi: String = txtBmi.text.toString()
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("age", age)
            editor.putString("gender", gender)
            editor.putString("crea", crea)
            editor.putString("hbalc", hbalc)
            editor.putString("cholos", cholos)
            editor.putString("trigy", trigy)
            editor.putString("hdl", hdl)
            editor.putString("ldl", ldl)
            editor.putString("vldl",vldl)
            editor.putString("bmi",bmi)
            editor.apply()
            editor.commit()

            val intent = Intent(this, HomeProfileActivity::class.java)
            startActivity(intent)

        })

    }
}