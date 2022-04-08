package com.android.employeelookup.application

import android.app.Application
import android.content.Context

class EmployeeApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: EmployeeApplication ?= null

        fun getApplicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}