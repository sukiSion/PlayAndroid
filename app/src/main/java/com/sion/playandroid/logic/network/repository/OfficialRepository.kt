package com.sion.playandroid.logic.network.repository

import android.app.Application
import androidx.paging.Config
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sion.playandroid.logic.base.pagesource.OfficialPagingSource

import com.sion.playandroid.logic.model.BaseModel
import com.sion.playandroid.logic.model.ClassifyModel
import com.sion.playandroid.logic.model.Query
import com.sion.playandroid.logic.network.PlayAndroidNetWork


class OfficialRepository constructor(application: Application) :BaseArticleRepository(application) {

    override suspend fun getArticleTree(): BaseModel<List<ClassifyModel>>
    = PlayAndroidNetWork.getWxArticleTree()

    override fun getPagingData(query: Query)= Pager(

        PagingConfig(

            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        )

    ){

        OfficialPagingSource(query.cid)

    }.flow
}