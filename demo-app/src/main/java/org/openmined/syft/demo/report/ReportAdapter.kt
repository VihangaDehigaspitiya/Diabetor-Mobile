package org.openmined.syft.demo.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.openmined.syft.demo.R
import org.openmined.syft.demo.server.model.ReportData

internal class ReportAdapter(
    private var reportList: List<ReportData>,
    val listener:ReportListener
) :
    RecyclerView.Adapter<ReportAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var result: TextView = view.findViewById(R.id.txtResult)
        var year: TextView = view.findViewById(R.id.txtDate)
        var clReport: ConstraintLayout = view.findViewById(R.id.clReport)
    }

    interface ReportListener{
        fun onBranchClicked(report:ReportData,position: Int)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_report, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = reportList[position]
        holder.result.text = movie.getResult()
        holder.year.text = movie.getYear()

        holder.clReport.setOnClickListener {
            listener.onBranchClicked(reportList[position],position)        }
    }

    override fun getItemCount(): Int {
        return reportList.size
    }
}