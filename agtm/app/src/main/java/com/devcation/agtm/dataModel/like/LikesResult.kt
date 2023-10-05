package com.devcation.agtm.dataModel.like

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class LikesWineResult (

    val pk : Int,

    val type :String,

    val user :OwnerResult,
    val wine : List<likeWine>
)

data class LikesClassResult (

    val pk : Int,

    val type :String,

    val user :OwnerResult,

    val agtmclass : List<likeClass>
)


data class likeWine (
    val pk : Int,
    val name :String,
    val name_en :String,
    val type :String,
    val price :Int,
    val photos :List<PhotoResult>
)

data class likeClass (
    val pk : Int,
    val title :String,
    val subtitle :String,
    val price :Int,
    val photos :List<PhotoResult>
)