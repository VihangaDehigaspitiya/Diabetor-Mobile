package org.openmined.syft.demo.report

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityHomeBinding
import org.openmined.syft.demo.databinding.ActivityReportBinding
import org.openmined.syft.demo.home.HomeViewModel
import org.openmined.syft.demo.home_profile.HomeProfileActivity
import org.openmined.syft.demo.report.report_details.ReportDetailsActivity

class ReportActivity : AppCompatActivity() {
    private lateinit var reportViewModel: ReportViewModel
    private lateinit var binding: ActivityReportBinding
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_report)
        reportViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ReportViewModel::class.java)


        binding.btnViewReport.setOnClickListener {
            val intent = Intent(this, ReportDetailsActivity::class.java)
            startActivity(intent)
        }

    }
}