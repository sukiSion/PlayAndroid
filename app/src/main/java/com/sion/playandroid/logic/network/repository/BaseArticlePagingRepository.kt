package com.sion.playandroid.logic.network.repository

import androidx.paging.PagingData
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.model.Query
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow


abstract class BaseArticlePagingRepository(){


    companion object{

        const val PAGE_SIZE = 15

    }

    abstract fun getPagingData(query: Query):Flow<PagingData<ArticleModel>>


}
