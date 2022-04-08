package com.android.employeelookup.network.repository

import com.android.employeelookup.network.models.EmployeeObject
import retrofit2.Response

interface EmployeeNetworkRepository {
    suspend fun getEmployees() : Response<EmployeeObject>
}