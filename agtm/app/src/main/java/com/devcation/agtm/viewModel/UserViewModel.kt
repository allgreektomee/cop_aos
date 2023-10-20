package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.dataModel.DefaultResult
import com.devcation.agtm.dataModel.like.LikesClassResult
import com.devcation.agtm.dataModel.like.LikesWineResult
import com.devcation.agtm.dataModel.user.MeResult
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineReviewResult
import com.devcation.agtm.repository.NetWorkRepository
import kotlinx.coroutines.launch


class UserViewModel : ViewModel() {
    private val netWorkRepository = NetWorkRepository()

    private var _mutableSign = MutableLiveData<DefaultResult>()
    val liveSign : LiveData<DefaultResult>
        get() = _mutableSign


    private var _mutableMe= MutableLiveData<MeResult>()
    val liveUserData: LiveData<MeResult>
        get() = _mutableMe



    private var _mutableLikeWine= MutableLiveData<List<LikesWineResult>>()
    val liveLikeWine: LiveData<List<LikesWineResult>>
        get() = _mutableLikeWine


    private var _mutableLikeClass= MutableLiveData<List<LikesClassResult>>()
    val liveLikeClass: LiveData<List<LikesClassResult>>
        get() = _mutableLikeClass


    private var _mutableOrderWine= MutableLiveData<List<LikesWineResult>>()
    val liveOrderWine: LiveData<List<LikesWineResult>>
        get() = _mutableOrderWine

    private var _mutableOrderClass= MutableLiveData<List<LikesClassResult>>()
    val liveOrderClass: LiveData<List<LikesClassResult>>
        get() = _mutableOrderClass


    fun login(signInDto: SignIn)= viewModelScope.launch{
        Log.d("MainViewModel", signInDto.toString())
        val login = netWorkRepository.login(signInDto)
        Log.d("MainViewModel", login.toString())

        _mutableSign.value = login

    }
    fun logout()= viewModelScope.launch{

        val logout = netWorkRepository.logout()
        Log.d("MainViewModel", logout.toString())
        _mutableSign.value = logout

    }


    fun me(username: String) = viewModelScope.launch {
        val me = netWorkRepository.me(username)

        Log.d("MainViewModel", me.toString())
        _mutableMe.value = me
    }

    fun signup(signup: SignUp) =  viewModelScope.launch {
        val signup = netWorkRepository.signup(signup)
        Log.d("MainViewModel", signup.toString())
        _mutableSign.value = signup
    }


//
//
//    fun getUserWineReviews(username: String,page: Int)  = viewModelScope.launch{
//        val reviews = netWorkRepository.getUserWineReviews(username, page)
//        Log.d("MainViewModel", reviews.toString())
//
////        Log.d("getWineDetail", wine.country.get("name").toString() )
//    }
//
//    fun getUserClassReviews(username: String,page: Int)  = viewModelScope.launch{
//        val reviews = netWorkRepository.getUserClassReviews(username, page)
//        Log.d("MainViewModel", reviews.toString())
//
////        Log.d("getWineDetail", wine.country.get("name").toString() )
//    }
//
//
    fun getUserWineLikes(username: String, page: Int)  = viewModelScope.launch{
        val like = netWorkRepository.getUserWineLikes(username, page)
        Log.d("MainViewModel", like.toString())
        _mutableLikeWine.value = like

//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getUserClassLikes(username: String, page: Int)  = viewModelScope.launch{
        val like = netWorkRepository.getUserClassLikes(username, page)
        Log.d("MainViewModel", like.toString())
        _mutableLikeClass.value = like
//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getUserWineOrder(username: String, page: Int)  = viewModelScope.launch{
        val like = netWorkRepository.getUserWineOrder(username, page)
        Log.d("MainViewModel", like.toString())
        _mutableOrderWine.value = like

//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }

    fun getUserClassOrder(username: String, page: Int)  = viewModelScope.launch{
        val like = netWorkRepository.getUserClassOrder(username, page)
        Log.d("MainViewModel", like.toString())
        _mutableOrderClass.value = like
//        Log.d("getWineDetail", wine.country.get("name").toString() )
    }


}