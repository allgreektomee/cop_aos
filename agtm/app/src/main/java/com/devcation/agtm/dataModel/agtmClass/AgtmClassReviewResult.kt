package com.devcation.agtm.dataModel.agtmClass

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class AgtmClassReviewResult (

    val pk : Int,
    val comment :String,
    val user :OwnerResult,
    val rating :Int,
    val agtmclass:AgtmClassReviewResult_class
    
    )


data class AgtmClassReviewResult_class(
    val pk : Int,
    val name :String,
    val name_en :String,
    val type :String,
    val price :Int,
    val photos:List<PhotoResult>
)