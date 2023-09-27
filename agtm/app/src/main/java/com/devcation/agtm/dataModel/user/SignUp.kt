package com.devcation.agtm.dataModel.user

import com.google.gson.annotations.SerializedName

data class SignUp(
    @SerializedName("email")
    var email :String? = "",

    @SerializedName("username")
    var username :String? = "",

    @SerializedName("password")
    var password :String? = "",

    @SerializedName("password2")
    var password2 :String? = ""
)