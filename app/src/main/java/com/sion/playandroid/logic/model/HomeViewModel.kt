package com.sion.playandroid.logic.model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sion.playandroid.ui.main.CourseTabs

class HomeViewModel:ViewModel() {

    private val _position = MutableLiveData<CourseTabs>(CourseTabs.HOME_PAGE)

    val position:LiveData<CourseTabs>
    get() = _position

    fun onPositionChange(position:CourseTabs ){

        _position.value = position

    }


}