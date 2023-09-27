package com.devcation.agtm.dataModel.agtmClass

import com.devcation.agtm.dataModel.OwnerResult
import com.devcation.agtm.dataModel.PhotoResult

data class AgtmClassDetailResult (
    val id : Int,
    val title : String,
    val subtitle : String,
    val place : String,
    val address : String,
    val price : Int,
    val start : String,
    val end : String,
    val headcount : Int,
    val create_at : String,
    val update_at : String,
    val owner : OwnerResult,
    val is_liked: Boolean,
    val photos : List<PhotoResult>,

        )



//{
//    "id": 1,
//    "owner": {
//    "img": "",
//    "username": "devcation",
//    "email": "devcation@gmail.com"
//},
//    "photos": [
//    {
//        "pk": 1,
//        "file": "https://imagedelivery.net/H4jrBT7_U0Ji_5U964zJAw/fd32667b-0dc6-4faa-6218-0a4fc79dd500/public",
//        "description": "프랑스 자수 클래스"
//    }
//    ],
//    "create_at": "2023-06-15T10:31:17.754973+09:00",
//    "update_at": "2023-06-15T10:31:17.755004+09:00",
//    "title": "프랑스 자수 한달반",
//    "subtitle": "마크라메 와인 홀더",
//    "description": "프랑스 자수 \r\n12일 오후 3시 반\r\n26일 오후 3시 반\r\n24일 오후 6시 반\r\n\r\n와인 한잔과 재료가 제공됩니다.",
//    "place": "올그릭투미",
//    "address": "신촌 서대문구 명물길34 1,2,3층",
//    "price": 35000,
//    "start": "15:00",
//    "end": "20:00",
//    "headcount": 6
//}