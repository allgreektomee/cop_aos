package com.devcation.agtm.dataModel.user

import com.google.gson.annotations.SerializedName



data class SignIn (
    @SerializedName("username")
    var username : String? = "",

    @SerializedName("password")
    var password : String? = ""

)