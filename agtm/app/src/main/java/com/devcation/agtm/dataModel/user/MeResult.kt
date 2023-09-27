package com.devcation.agtm.dataModel.user

data class  MeResult (
    val last_login : String,
    val date_joined : String,
    val username :String,
    val first_name :String,
    val last_name :String,
    val email :String,
    val img :String,
    val gender :String,
    val detail : String,
    val is_visit :Boolean
)
