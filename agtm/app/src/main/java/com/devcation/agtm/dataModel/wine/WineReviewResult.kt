package com.devcation.agtm.dataModel.wine

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class WineReviewResult (

    val pk : Int,
    val comment :String,
    val user :OwnerResult,
    val rating :Int,
    val wine:WineReviewResult_Wine

    )


data class WineReviewResult_Wine(
    val pk : Int,
    val name :String,
    val name_en :String,
    val type :String,
    val price :Int,
    val photos:List<PhotoResult>
)