package com.sion.playandroid.logic.network.repository


import android.app.Application
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sion.playandroid.logic.base.pagesource.ProjectPagingSource
import com.sion.playandroid.logic.model.*
import com.sion.playandroid.logic.network.PlayAndroidNetWork


class ProjectRepository  constructor(val application: Application) :BaseArticleRepository(application = application) {


    override suspend fun getArticleTree(): BaseModel<List<ClassifyModel>> {
        return PlayAndroidNetWork.getProjectTree()
    }

    @ExperimentalPagingApi
    override fun getPagingData(query: Query) = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        )
    ) {
        ProjectPagingSource(query.cid)
    }.flow

}