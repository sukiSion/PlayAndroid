package com.sion.playandroid.logic.model

import android.app.Application
import com.sion.playandroid.logic.network.repository.BaseArticlePagingRepository
import com.sion.playandroid.logic.network.repository.ProjectRepository


class ProjectViewModel(application: Application):BaseViewModel(application) {

    override val repositoryArticle: BaseArticlePagingRepository
        get() = ProjectRepository(getApplication())

    override suspend fun getData() {

        (repositoryArticle as ProjectRepository).getTree(mutableTreeLiveData)

    }




}