package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.dataModel.DefaultResult
import com.devcation.agtm.dataModel.wine.WineDetailResult
import com.devcation.agtm.dataModel.wine.WineReviewResult
import com.devcation.agtm.repository.NetWorkRepository
import kotlinx.coroutines.launch


class UserViewModel : ViewModel() {
    private val netWorkRepository = NetWorkRepository()

    private var _mutableSign = MutableLiveData<DefaultResult>()
    val liveSign : LiveData<DefaultResult>
        get() = _mutableSign










    private var _mutableWineDetail = MutableLiveData<WineDetailResult>()
    val liveWineDetail : LiveData<WineDetailResult>
        get() = _mutableWineDetail


    private var _mutableWineList3 = MutableLiveData<List<WineReviewResult>>()
    val liveWineList3 : LiveData<List<WineReviewResult>>
        get() = _mutableWineList3


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
    }

    fun signup(signup: SignUp) =  viewModelScope.launch {
        val signup = netWorkRepository.signup(signup)
        Log.d("MainViewModel", signup.toString())
        _mutableSign.value = signup
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


}