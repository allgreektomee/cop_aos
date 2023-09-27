package com.devcation.agtm.dataModel.wine

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class WineDetailResult (
    val id : Int,
    val grapes : dto,
    val region : dto,
    val owner : OwnerResult,
    val country : dto,
    val photos :List<PhotoResult>,
    val pairings :List<dto>,
    val styles : List<dto>,
    val is_liked : Boolean,
    val is_owner : Boolean,
    val create_at : String,
    val update_at : String,
    val name :String,
    val name_en :String,
    val type :String,
    val price :Int,
    val is_soldout :Boolean,
    val description: String,
    val Alcohol : Double,
    val taste_sugar : Int,
    val taste_acidity : Int,
    val taste_tannin : Int,
    val taste_body : Int,
)

data class dto (
    val pk : Int,
    val name : String,
    val description : String,
)

