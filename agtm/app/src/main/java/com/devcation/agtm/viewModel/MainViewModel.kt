package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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


    private var _mutableWineList3 = MutableLiveData<List<WineReviewResult>>()
    val liveWineList3 : LiveData<List<WineReviewResult>>
        get() = _mutableWineList3


    fun getWine(page : Int) = viewModelScope.launch {
        val getWine = netWorkRepository.getWine(page)
        Log.d("MainViewModel", getWine.toString())

        Log.d("MainViewModel", getWine[0].country.get("name").toString() )
        _mutableWineList.value = getWine
    }

    fun getWineRecommand(recommand: String, page : Int) = viewModelScope.launch {
        val getWine = netWorkRepository.getWineRecommand(recommand,page)
        Log.d("MainViewModel", getWine.toString())

        when (recommand) {
            "agtm" -> _mutableWineList_recommad_1.value = getWine
            "pick" -> _mutableWineList_recommad_2.value = getWine
            "month" -> _mutableWineList_recommad_3.value = getWine
        }

    }


    fun getWineDetail(id : Int) = viewModelScope.launch{
        val wine = netWorkRepository.getWineDetail(id)

        _mutableWineDetail.value = wine
    }



    fun getWineReviews(id: Int, page: Int)  = viewModelScope.launch{
        val reviews = netWorkRepository.getWineReviews(id, page)
        Log.d("MainViewModel", reviews.toString())
        Log.d("MainViewModel", reviews[0].user.username)
        Log.d("MainViewModel", reviews[0].comment)

//        Log.d("getWineDetail", wine.country.get("name").toString() )
        _mutableWineList3.value = reviews
    }




    fun login(signInDto: SignIn)= viewModelScope.launch{
        Log.d("MainViewModel", signInDto.toString())
        val login = netWorkRepository.login(signInDto)
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

    fun getUserWineLikes(username: String, page: Int)  = viewModelScope.launch{
        val like = netWorkRepository.getUserWineLikes(username, page)
        Log.d("MainViewModel", like.toString())

//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getUserClassLikes(username: String, page: Int)  = viewModelScope.launch{
        val like = netWorkRepository.getUserClassLikes(username, page)
        Log.d("MainViewModel", like.toString())

//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getAgtmClass(page: Int) =  viewModelScope.launch {
        val agtmClass = netWorkRepository.getAgtmClass(page)
        Log.d("MainViewModel", agtmClass.toString())
    }

    fun getAgtmClassDetail(id : Int) =  viewModelScope.launch {
        val agtmClass = netWorkRepository.getAgtmClassDetail(id)
        Log.d("MainViewModel", agtmClass.toString())
    }


}