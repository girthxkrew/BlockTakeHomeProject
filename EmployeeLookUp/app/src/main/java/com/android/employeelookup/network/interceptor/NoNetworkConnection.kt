package com.android.employeelookup.network.interceptor

import java.io.IOException

class NoNetworkConnection(override val message: String) : IOException(message)