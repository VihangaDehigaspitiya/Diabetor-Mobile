package org.openmined.syft.demo.report

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import es.dmoral.toasty.Toasty
import org.openmined.syft.demo.R
import org.openmined.syft.demo.databinding.ActivityReportBinding
import org.openmined.syft.demo.report.report_details.ReportDetailsActivity
import org.openmined.syft.demo.server.model.ReportData
import org.openmined.syft.demo.server.model.SingleReportRow
import org.openmined.syft.demo.server.service.RestApiService
import java.io.StringReader
import java.lang.reflect.Type

class ReportActivity : AppCompatActivity() {
    private lateinit var reportViewModel: ReportViewModel
    private lateinit var binding: ActivityReportBinding
   // private val reportList = ArrayList<ReportData>()
    private lateinit var reportAdapter: ReportAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_report)
        reportViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ReportViewModel::class.java)

        getReports()




        //prepareReportData()

        binding.btnViewReport.setOnClickListener {
            val intent = Intent(this, ReportDetailsActivity::class.java)
            startActivity(intent)
        }

        binding.btnCancel.setOnClickListener{
            onBackPressed()
        }

    }


    fun getReports() {
        val apiService = RestApiService()
        apiService.getAllPredictions {
            if (it?.status == true) {
                try{
                    var predictionString = it.value.toString();
                    val listType: Type = object : TypeToken<ArrayList<ReportData>>() {}.getType()
                    var predictionList: List<ReportData> = Gson().fromJson(predictionString, listType);
                    val recyclerView: RecyclerView = findViewById(R.id.rvReport)
                    reportAdapter = ReportAdapter(predictionList)
                    val layoutManager = LinearLayoutManager(applicationContext)
                    recyclerView.layoutManager = layoutManager
                    recyclerView.itemAnimator = DefaultItemAnimator()
                    recyclerView.adapter = reportAdapter;
                    reportAdapter.notifyDataSetChanged()

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


    /*private fun prepareReportData() {
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
    }*/
}