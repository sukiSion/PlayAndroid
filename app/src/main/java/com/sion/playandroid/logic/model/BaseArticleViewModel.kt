package com.sion.playandroid.logic.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sion.playandroid.logic.network.repository.BaseArticlePagingRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

abstract class BaseArticleViewModel(application: Application):AndroidViewModel(application) {

    abstract val repositoryArticle: BaseArticlePagingRepository

    private val searchResults = MutableSharedFlow<Query>(replay = 1)


    @OptIn(ExperimentalStdlibApi::class)
    val articleResult : Flow<PagingData<ArticleModel>> = searchResults.flatMapLatest {

        repositoryArticle.getPagingData(it)

    }.cachedIn(viewModelScope)

    private var searchJob: Job? = null

    open fun searchArticle(query: Query){

        searchJob?.cancel()

        searchJob = viewModelScope.launch {

            searchResults.emit(query)

        }

    }

}