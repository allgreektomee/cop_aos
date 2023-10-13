package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.agtmClass.AgtmClassDetailResult
import com.devcation.agtm.dataModel.agtmClass.AgtmClassResult
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.wine.WineResult
import com.devcation.agtm.repository.NetWorkRepository
import kotlinx.coroutines.launch

class ClassViewModel : ViewModel() {
    private val netWorkRepository = NetWorkRepository()

    private var _mutableClassList = MutableLiveData<List<AgtmClassResult>>()
    val liveClassList : LiveData<List<AgtmClassResult>>
        get() = _mutableClassList


    private var _mutableClass = MutableLiveData<AgtmClassDetailResult>()
    val liveClassDetail : LiveData<AgtmClassDetailResult>
        get() = _mutableClass

    fun getAgtmClass(page: Int) =  viewModelScope.launch {
        val agtmClass = netWorkRepository.getAgtmClass(page)
        Log.d("MainViewModel", agtmClass.toString())
        _mutableClassList.value = agtmClass
    }

    fun getAgtmClassDetail(id : Int) =  viewModelScope.launch {
        val classDetail = netWorkRepository.getAgtmClassDetail(id)
        Log.d("MainViewModel", classDetail.toString())

        _mutableClass.value = classDetail
    }


    fun getAgtmClassLikeToggle(username:String, id: Int, type: LikeType)= viewModelScope.launch {
        val classDetail = netWorkRepository.getAgtmClassLikeToggle(username, id, type)
        Log.d("getAgtmClassLikeToggle", classDetail.toString())


    }

}