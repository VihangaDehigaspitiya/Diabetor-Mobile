package org.openmined.syft.demo.report

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityHomeBinding
import org.openmined.syft.demo.databinding.ActivityReportBinding
import org.openmined.syft.demo.home.HomeViewModel
import org.openmined.syft.demo.home_profile.HomeProfileActivity
import org.openmined.syft.demo.report.report_details.ReportDetailsActivity
import org.openmined.syft.demo.server.model.ReportData

class ReportActivity : AppCompatActivity() {
    private lateinit var reportViewModel: ReportViewModel
    private lateinit var binding: ActivityReportBinding
    private val reportList = ArrayList<ReportData>()
    private lateinit var reportAdapter: ReportAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_report)
        reportViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ReportViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.rvReport)
        reportAdapter = ReportAdapter(reportList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = reportAdapter

        prepareReportData()

        binding.btnViewReport.setOnClickListener {
            val intent = Intent(this, ReportDetailsActivity::class.java)
            startActivity(intent)
        }

        binding.btnCancel.setOnClickListener{
            onBackPressed()
        }

    }


    private fun prepareReportData() {
        var report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Positive", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Positive", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Positive", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "11/09/2021","")
        reportList.add(report)
        report = ReportData("Negative", "19/09/2021","")
        reportList.add(report)
        reportAdapter.notifyDataSetChanged()
    }
}