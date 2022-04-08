package com.android.employeelookup.network.models

import com.google.gson.annotations.SerializedName


data class EmployeeObject (

    @SerializedName("employees" ) var employees : ArrayList<Employee> = arrayListOf()

)