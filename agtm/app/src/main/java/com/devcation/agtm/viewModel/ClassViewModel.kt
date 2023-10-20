package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.agtmClass.AgtmClassDetailResult
import com.devcation.agtm.dataModel.agtmClass.AgtmClassResult
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.reviews.Review
import com.devcation.agtm.dataModel.reviews.ReviewResult
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


    private var _mutableReviews = MutableLiveData<MutableList<ReviewResult>?>()
    val liveReviews : MutableLiveData<MutableList<ReviewResult>?>
        get() = _mutableReviews


    fun getAgtmClass(username: String, page: Int) =  viewModelScope.launch {
        val agtmClass = netWorkRepository.getAgtmClass(username, page)
        Log.d("MainViewModel", agtmClass.toString())
        _mutableClassList.value = agtmClass
    }

    fun getAgtmClassDetail(id : Int,  username:String) =  viewModelScope.launch {
        val classDetail = netWorkRepository.getAgtmClassDetail(id, username)
        Log.d("MainViewModel", classDetail.toString())

        _mutableClass.value = classDetail
    }


    fun getAgtmClassLikeToggle(username:String, id: Int, type: LikeType)= viewModelScope.launch {
        val classDetail = netWorkRepository.getAgtmClassLikeToggle(username, id, type)
        Log.d("getAgtmClassLikeToggle", classDetail.toString())


    }


    fun getReviews( id: Int, username:String, page: Int)  = viewModelScope.launch{
        val reviews = netWorkRepository.getAgtmClassReviews( id, username, page)

        Log.d("getWineReviews", reviews.toString())
        _mutableReviews.value = reviews
    }

    fun reviews( id: Int, username:String, page: Int, review: Review)  = viewModelScope.launch{
        val reviewResult = netWorkRepository.agtmClassReviews( id, username, page, review)

        var tempList= _mutableReviews.value
        if (tempList != null) {
            tempList.add(reviewResult)
        }
        _mutableReviews.value = tempList

    }

}