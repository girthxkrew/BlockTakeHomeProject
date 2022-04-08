package com.android.employeelookup.network.repository

import com.android.employeelookup.network.models.EmployeeObject
import com.android.employeelookup.network.retrofit.EmployeeAPI
import com.android.employeelookup.network.retrofit.RetrofitSingleton
import retrofit2.Response

class EmployeeNetworkRepositoryImp : EmployeeNetworkRepository {
    private val employeeAPI: EmployeeAPI = RetrofitSingleton.employeeAPI

    override suspend fun getEmployees(): Response<EmployeeObject> {
        return employeeAPI.getEmployees()
    }
}