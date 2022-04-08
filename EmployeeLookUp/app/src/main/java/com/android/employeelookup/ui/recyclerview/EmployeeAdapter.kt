package com.android.employeelookup.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.employeelookup.R
import com.android.employeelookup.network.models.Employee
import com.squareup.picasso.Picasso

class EmployeeAdapter(private val employeeList : ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val employeePicture : ImageView = itemView.findViewById(R.id.employee_picture)
        val employeeName : TextView = itemView.findViewById(R.id.employee_name)
        val employeeTeam : TextView = itemView.findViewById(R.id.employee_team)
        val employeeSummary : TextView = itemView.findViewById(R.id.employee_summary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_item, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val currentEmployee = employeeList[position]
        val picasso = Picasso.get()
        picasso.load(currentEmployee.photoUrlLarge).error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder).into(holder.employeePicture)
        holder.employeeName.text = currentEmployee.fullName
        holder.employeeTeam.text = currentEmployee.team
        holder.employeeSummary.text = currentEmployee.biography
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}