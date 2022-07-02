package com.sion.playandroid.logic.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel(application: Application):BaseArticleViewModel(application) {

    protected val mutableTreeLiveData = MutableLiveData<PlayState>()

    val treeLiveData: LiveData<PlayState>
        get() = mutableTreeLiveData

    abstract suspend fun getData()

    fun getDataList() {
        viewModelScope.launch(Dispatchers.IO) {
            getData()
        }
    }

    private val _position = MutableLiveData(0)
    val position: LiveData<Int> = _position

    fun onPositionChanged(position: Int) {
        _position.value = position
    }
}