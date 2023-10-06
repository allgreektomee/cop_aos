package com.devcation.agtm.dataModel.wine

import com.devcation.agtm.dataModel.PhotoResult

data class WineResult (

    val pk : Int,
    val name :String,
    val name_en :String,
    val type :String,
    val price :Int,
    val is_soldout :Boolean,
    val owner :Int,
    val Alcohol : Double,
    val country :  Map<String, Any>,
    val is_owner : Boolean,
    val is_liked: Boolean,
    val photos :List<PhotoResult>
)