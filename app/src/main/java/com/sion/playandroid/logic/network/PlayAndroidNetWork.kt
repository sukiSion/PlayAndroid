package com.sion.playandroid.logic.network

import com.sion.playandroid.logic.network.service.HomePageService
import com.sion.playandroid.logic.network.service.ServiceCreator


object PlayAndroidNetWork {

    // 创建动代对象
    private val homePageService = ServiceCreator.create<HomePageService>()

    suspend fun getBanner() = homePageService.getBanner()

    suspend fun getArticle(page:Int) =  homePageService.getArticle(page)

}