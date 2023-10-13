package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.notice.NoticeDetailResult
import com.devcation.agtm.dataModel.notice.NoticeResult
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineResult
import com.devcation.agtm.repository.NetWorkRepository
import kotlinx.coroutines.launch


//    Noti = ("1", "Noti")
//    Event = ("2", "Event")
//    Magazine = ("3", "Magazine")
//    Banner = ("4", "Banner")
//    Link = ("5", "Link"),


class NoticeViewModel: ViewModel()  {
    private val netWorkRepository = NetWorkRepository()

    private var _mutableNotice = MutableLiveData<List<NoticeResult>>()
    val liveNotice : LiveData<List<NoticeResult>>
        get() = _mutableNotice


    private var _mutableNotice_noti = MutableLiveData<List<NoticeResult>>()
    val liveNotice_noti : LiveData<List<NoticeResult>>
        get() = _mutableNotice_noti

    private var _mutableNotice_event = MutableLiveData<List<NoticeResult>>()
    val liveNotice_event : LiveData<List<NoticeResult>>
        get() = _mutableNotice_event

    private var _mutableNotice_magazine = MutableLiveData<List<NoticeResult>>()
    val liveNotice_magazine : LiveData<List<NoticeResult>>
        get() = _mutableNotice_magazine

    private var _mutableNotice_banner = MutableLiveData<List<NoticeResult>>()
    val liveNotice_banner : LiveData<List<NoticeResult>>
        get() = _mutableNotice_banner


    private var _mutableNotice_link = MutableLiveData<List<NoticeResult>>()
    val liveNotice_link : LiveData<List<NoticeResult>>
        get() = _mutableNotice_link



    private var _mutableNoticeDetail = MutableLiveData<NoticeDetailResult>()
    val liveNoticeDetail : LiveData<NoticeDetailResult>
        get() = _mutableNoticeDetail

    fun getNoticeType(type:Int, page:Int) = viewModelScope.launch {
        val getNotiType = netWorkRepository.getNoticeType(type, page)
        Log.d("WINETYPE",getNotiType.toString())
        when (type) {
            1 -> _mutableNotice_noti.value = getNotiType
            2 -> _mutableNotice_event.value = getNotiType
            3 -> _mutableNotice_magazine.value = getNotiType
            4 -> _mutableNotice_banner.value = getNotiType
            5 -> _mutableNotice_link.value = getNotiType

        }
    }

    fun getNotice(page:Int) = viewModelScope.launch {
        val getNoti = netWorkRepository.getNotice(page)
        Log.d("WINETYPE",getNoti.toString())

        _mutableNotice.value = getNoti

    }

    fun getNoticeDetail(id:Int) = viewModelScope.launch {
        val getNotiDetail = netWorkRepository.getNoticeDetail(id)


        _mutableNoticeDetail.value = getNotiDetail

    }
}