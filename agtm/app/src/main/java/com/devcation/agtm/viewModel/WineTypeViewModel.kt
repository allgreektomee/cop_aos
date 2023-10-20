package com.devcation.agtm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcation.agtm.dataModel.wine.WineResult
import com.devcation.agtm.repository.NetWorkRepository
import kotlinx.coroutines.launch

class WineTypeViewModel: ViewModel() {
    private val netWorkRepository = NetWorkRepository()

    private var _mutableWineType_red = MutableLiveData<List<WineResult>>()
    val liveWineType_red : LiveData<List<WineResult>>
        get() = _mutableWineType_red


    private var _mutableWineType_white = MutableLiveData<List<WineResult>>()
    val liveWineType_white : LiveData<List<WineResult>>
        get() = _mutableWineType_white


    private var _mutableWineType_natural = MutableLiveData<List<WineResult>>()
    val liveWineType_natural : LiveData<List<WineResult>>
        get() = _mutableWineType_natural

    private var _mutableWineType_rose = MutableLiveData<List<WineResult>>()
    val liveWineType_rose : LiveData<List<WineResult>>
        get() = _mutableWineType_rose


    private var _mutableWineType_sweet = MutableLiveData<List<WineResult>>()
    val liveWineType_sweet : LiveData<List<WineResult>>
        get() = _mutableWineType_sweet

    private var _mutableWineType_sparkling = MutableLiveData<List<WineResult>>()
    val liveWineType_sparkling : LiveData<List<WineResult>>
        get() = _mutableWineType_sparkling



    fun getWineType( type: String, username:String, page : Int) = viewModelScope.launch {
        val getWineType = netWorkRepository.getWineType( type,username, page)
        Log.d("WINETYPE",getWineType.toString())
        when (type) {
            "red" -> _mutableWineType_red.value = getWineType
            "white" -> _mutableWineType_white.value = getWineType
            "natural" -> _mutableWineType_natural.value = getWineType
            "rose" -> _mutableWineType_rose.value = getWineType
            "sweet" -> _mutableWineType_sweet.value = getWineType
            "sparkling" -> _mutableWineType_sparkling.value = getWineType
        }

    }

}