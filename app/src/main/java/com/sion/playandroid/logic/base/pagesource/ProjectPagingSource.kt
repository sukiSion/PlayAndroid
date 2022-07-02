package com.sion.playandroid.logic.base.pagesource

import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.network.PlayAndroidNetWork

class ProjectPagingSource(private val cid:Int):BasePageSource(){

    override suspend fun getArticleList(page: Int): List<ArticleModel> {

        val articles_response = PlayAndroidNetWork.getProject(page,cid)

        return articles_response.data.datas

    }
}