package com.android.employeelookup.network.retrofit

import com.android.employeelookup.network.models.EmployeeObject
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeAPI{

    @GET("/sq-mobile-interview/employees.json")
    suspend fun getEmployees() : Response<EmployeeObject>
}