package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.user.Login
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


    private var _mutableWineList2 = MutableLiveData<WineDetailResult>()
    val liveWineList2 : LiveData<WineDetailResult>
        get() = _mutableWineList2


    private var _mutableWineList3 = MutableLiveData<List<WineReviewResult>>()
    val liveWineList3 : LiveData<List<WineReviewResult>>
        get() = _mutableWineList3


    fun getWine(page : Int) = viewModelScope.launch {
        val getWine = netWorkRepository.getWine(page)
        Log.d("MainViewModel", getWine.toString())

        Log.d("MainViewModel", getWine[0].country.get("name").toString() )
        _mutableWineList.value = getWine
    }

    fun getWineDetail(id : Int) = viewModelScope.launch{
        val wine = netWorkRepository.getWineDetail(id)
        Log.d("MainViewModel", wine.toString())
        Log.d("MainViewModel", wine.pairings[0].description)
        Log.d("MainViewModel", wine.styles[0].description)

//        Log.d("getWineDetail", wine.country.get("name").toString() )
        _mutableWineList2.value = wine
    }

    fun getWineReviews(id: Int, page: Int)  = viewModelScope.launch{
        val reviews = netWorkRepository.getWineReviews(id, page)
        Log.d("MainViewModel", reviews.toString())
        Log.d("MainViewModel", reviews[0].user.username)
        Log.d("MainViewModel", reviews[0].comment)

//        Log.d("getWineDetail", wine.country.get("name").toString() )
        _mutableWineList3.value = reviews
    }




    fun login(loginDto: Login)= viewModelScope.launch{
        Log.d("MainViewModel", loginDto.toString())
        val login = netWorkRepository.login(loginDto)
        Log.d("MainViewModel", login.toString())


    }

    fun me() = viewModelScope.launch {
        val me = netWorkRepository.me()

        Log.d("MainViewModel", me.toString())
    }

    fun signup(signup: SignUp) =  viewModelScope.launch {
        val signup = netWorkRepository.signup(signup)
        Log.d("MainViewModel", signup.toString())
    }

    fun getUserWineReviews(username: String,page: Int)  = viewModelScope.launch{
        val reviews = netWorkRepository.getUserWineReviews(username, page)
        Log.d("MainViewModel", reviews.toString())

//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getUserClassReviews(username: String,page: Int)  = viewModelScope.launch{
        val reviews = netWorkRepository.getUserClassReviews(username, page)
        Log.d("MainViewModel", reviews.toString())

//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getAgtmClass() =  viewModelScope.launch {
        val agtmClass = netWorkRepository.getAgtmClass()
        Log.d("MainViewModel", agtmClass.toString())
    }

    fun getAgtmClassDetail(id : Int) =  viewModelScope.launch {
        val agtmClass = netWorkRepository.getAgtmClassDetail(id)
        Log.d("MainViewModel", agtmClass.toString())
    }


}