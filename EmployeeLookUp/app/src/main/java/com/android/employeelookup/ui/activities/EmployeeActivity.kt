package com.android.employeelookup.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.employeelookup.R
import com.android.employeelookup.network.models.Employee
import com.android.employeelookup.ui.recyclerview.EmployeeAdapter
import com.android.employeelookup.ui.viewmodels.EmployeeViewModel

class EmployeeActivity : AppCompatActivity() {
    private lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var employeeRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        employeeRecyclerView = findViewById(R.id.employee_recyclerview)
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)
        employeeViewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]
        employeeViewModel.getEmployees().observe(this) {
            if (it != null) {
                employeeRecyclerView.adapter = EmployeeAdapter(it)
            } else if (!employeeViewModel.hasError.value!! && it == null) {

            }
            swipeRefreshLayout.isRefreshing = false
        }
        swipeRefreshLayout = findViewById(R.id.employee_swipe_layout)

        swipeRefreshLayout.setOnRefreshListener {
            employeeViewModel.getEmployees()
        }

        employeeViewModel.hasError.observe(this) {
            if (it) {
                val toast = Toast.makeText(this, "Please check your internet connectivity or refresh to try again", Toast.LENGTH_SHORT)
                toast.show()
                val employees : ArrayList<Employee>? = employeeViewModel.getEmployees().value
                if (employees == null) {
                    val employee = Employee(null, "Ryan Martinez", null,
                        null, "Is Awesome", null,
                        "www.google.com", "Jacob", null)
                    val employeeList = ArrayList<Employee>()
                    employeeList.add(employee)
                    employeeRecyclerView.adapter = EmployeeAdapter(employeeList)
                }
            }
        }

    }
}