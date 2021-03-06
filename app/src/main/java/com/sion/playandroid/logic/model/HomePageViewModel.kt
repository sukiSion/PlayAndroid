package com.sion.playandroid.logic.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sion.playandroid.logic.network.repository.BaseArticlePagingRepository
import com.sion.playandroid.logic.network.repository.HomeArticlePagingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomePageViewModel(application: Application):BaseArticleViewModel(application) {

    override val repositoryArticle: BaseArticlePagingRepository
        get() = HomeArticlePagingRepository()

    private var bannerJob:Job? = null

    private val _bannerState = MutableLiveData<PlayState>()

    val bannerState : LiveData<PlayState>
    get() = _bannerState

    fun getData(){

        getBanner()

        searchArticle(Query())

    }

    private fun getBanner(){

        bannerJob?.cancel()

        bannerJob = viewModelScope.launch(Dispatchers.IO) {

            (repositoryArticle as HomeArticlePagingRepository).getBanner(_bannerState)

        }

    }

}