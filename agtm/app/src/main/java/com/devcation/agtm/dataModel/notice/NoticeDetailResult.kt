package com.devcation.agtm.dataModel.notice

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class NoticeDetailResult (
    val id : Int,
    val owner : OwnerResult,
    val photos : List<PhotoResult>,
    val create_at : String,
    val update_at : String,
    val name : String,
    val name_en : String,
    val type : String,
    val URL : String,
    val description : String,

)