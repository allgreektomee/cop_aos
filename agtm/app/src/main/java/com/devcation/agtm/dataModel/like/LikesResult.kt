package com.devcation.agtm.dataModel.like

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult
import com.devcation.agtm.dataModel.wine.dto

data class LikesWineResult (

    val pk : Int,

    val type :String,

    val user :OwnerResult,
    val wine : likeWine
)

data class LikesClassResult (

    val pk : Int,

    val type :String,

    val user :OwnerResult,

    val agtmclass : likeClass
)


data class likeWine (
    val pk : Int,
    val name :String,
    val name_en :String,
    val type :String,
    val price :Int,
    val photos :List<PhotoResult>,
    var country : dto
)
data class likeClass (
    val pk : Int,
    val title :String,
    val subtitle :String,
    val price :Int,
    val photos :List<PhotoResult>,
    val place:String,
    var start:String,
    var end:String
)

