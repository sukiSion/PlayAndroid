package com.sion.playandroid.logic.network

import com.sion.playandroid.logic.network.service.HomePageService
import com.sion.playandroid.logic.network.service.OfficialService
import com.sion.playandroid.logic.network.service.ProjectService
import com.sion.playandroid.logic.network.service.ServiceCreator


object PlayAndroidNetWork {

    // 创建动代对象
    private val homePageService = ServiceCreator.create<HomePageService>()

    private val projectService = ServiceCreator.create<ProjectService>()

    private val officialService = ServiceCreator.create<OfficialService>()

    suspend fun getBanner() = homePageService.getBanner()

    suspend fun getArticle(page:Int) =  homePageService.getArticle(page)

    suspend fun getProjectTree() = projectService.getProjectTree()

    suspend fun getProject(page: Int,cid:Int) = projectService.getProject(page,cid)

    suspend fun getWxArticleTree() = officialService.getWxArticleTree()

    suspend fun getWxArticle(page: Int,cid: Int) = officialService.getWxArticle(page,cid)

}