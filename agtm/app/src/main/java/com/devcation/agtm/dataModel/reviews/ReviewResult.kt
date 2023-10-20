package com.devcation.agtm.dataModel.reviews

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class ReviewResult (
    val pk : Int,
    val user : OwnerResult,
    val create_at : String,
    val update_at : String,
    val comment : String,
    val rating : String,

    )