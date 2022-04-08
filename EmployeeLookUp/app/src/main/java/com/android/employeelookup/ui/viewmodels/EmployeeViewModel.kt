package com.android.employeelookup.ui.viewmodels

import androidx.lifecycle.*
import com.android.employeelookup.network.models.Employee
import com.android.employeelookup.network.repository.EmployeeNetworkRepositoryImp
import kotlinx.coroutines.launch

class EmployeeViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val storedList = "STORED_LIST"
    }

    private val employees = state.getLiveData<ArrayList<Employee>>(storedList)
    private val employeeNetworkRepository: EmployeeNetworkRepositoryImp = EmployeeNetworkRepositoryImp()
    val hasError = MutableLiveData<Boolean>()

    fun getEmployees() : LiveData<ArrayList<Employee>> {

        if (!state.contains(storedList)) {
            viewModelScope.launch {
                try {
                    var response = employeeNetworkRepository.getEmployees()
                    if (response.isSuccessful) {
                        state.set(storedList, response.body()?.employees)
                    }
                } catch (e : Exception) {
                    hasError.postValue(true)
                }

            }
        }
        return employees
    }

    fun getEmployeesLiveData() : LiveData<ArrayList<Employee>> {
        return employees
    }
}