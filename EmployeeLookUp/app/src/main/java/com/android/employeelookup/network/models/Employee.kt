package com.android.employeelookup.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employee(
    @SerializedName("uuid") var uuid : String? = null,
    @SerializedName("full_name") var fullName : String? = null,
    @SerializedName("phone_number") var phoneNumber : String? = null,
    @SerializedName("email_address") var emailAddress : String? = null,
    @SerializedName("biography") var biography : String? = null,
    @SerializedName("photo_url_small") var photoUrlSmall : String? = null,
    @SerializedName("photo_url_large") var photoUrlLarge : String? = null,
    @SerializedName("team") var team : String? = null,
    @SerializedName("employee_type") var employeeType : String? = null
) : Parcelable
