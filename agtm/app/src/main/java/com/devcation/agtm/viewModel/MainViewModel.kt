package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.like.LikeType
import com.devcation.agtm.dataModel.reviews.Review
import com.devcation.agtm.dataModel.reviews.ReviewResult
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.dataModel.wine.WineResult
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineReviewResult
import com.devcation.agtm.repository.NetWorkRepository
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    private val netWorkRepository = NetWorkRepository()

    private var _mutableWineList = MutableLiveData<List<WineResult>>()
    val liveWineList : LiveData<List<WineResult>>
        get() = _mutableWineList


    private var _mutableWineList_recommad_1 = MutableLiveData<List<WineResult>>()
    val liveWineList_recommand_1 : LiveData<List<WineResult>>
        get() = _mutableWineList_recommad_1


    private var _mutableWineList_recommad_2 = MutableLiveData<List<WineResult>>()
    val liveWineList_recommand_2 : LiveData<List<WineResult>>
        get() = _mutableWineList_recommad_2

    private var _mutableWineList_recommad_3 = MutableLiveData<List<WineResult>>()
    val liveWineList_recommand_3 : LiveData<List<WineResult>>
        get() = _mutableWineList_recommad_3






    private var _mutableWineDetail = MutableLiveData<WineDetailResult>()
    val liveWineDetail : LiveData<WineDetailResult>
        get() = _mutableWineDetail


    private var _mutableWineReviews = MutableLiveData<MutableList<ReviewResult>?>()
    val liveWineReviews : MutableLiveData<MutableList<ReviewResult>?>
        get() = _mutableWineReviews



    fun getWine(page : Int, username:String) = viewModelScope.launch {
        val getWine = netWorkRepository.getWine(page, username)
        Log.d("MainViewModel", getWine.toString())

        Log.d("MainViewModel", getWine[0].country.get("name").toString() )
        _mutableWineList.value = getWine


    }

    fun getWineRecommand(username:String, recommand: String, page : Int) = viewModelScope.launch {

        val getWine = netWorkRepository.getWineRecommand(username, recommand, page)
        Log.d("getWineRecommand", getWine.toString())

        when (recommand) {
            "agtm" -> _mutableWineList_recommad_1.value = getWine
            "pick" -> _mutableWineList_recommad_2.value = getWine
            "month" -> _mutableWineList_recommad_3.value = getWine
        }

    }


    fun getWineDetail(username:String, id : Int) = viewModelScope.launch{
        val wine = netWorkRepository.getWineDetail(username,id)

        _mutableWineDetail.value = wine
    }



    fun getWineReviews( id: Int, username:String, page: Int)  = viewModelScope.launch{
        val reviews = netWorkRepository.getWineReviews( id, username, page)

        Log.d("getWineReviews", reviews.toString())
        _mutableWineReviews.value = reviews
    }

    fun wineReviews( id: Int, username:String, page: Int, review: Review)  = viewModelScope.launch{
        val reviewResult = netWorkRepository.wineReviews( id, username, page, review)

        var tempList= _mutableWineReviews.value
        if (tempList != null) {
            tempList.add(reviewResult)
        }
        _mutableWineReviews.value = tempList

    }

    fun getWineLikeToggle(username:String, id: Int, type: LikeType) = viewModelScope.launch{
        val wineToggle = netWorkRepository.getWineLikeToggle(username, id, type)

        Log.d("wineToggle", wineToggle.toString() )
    }





}