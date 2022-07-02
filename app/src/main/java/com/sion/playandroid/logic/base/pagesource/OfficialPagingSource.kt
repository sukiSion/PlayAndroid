package com.sion.playandroid.logic.base.pagesource

import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.network.PlayAndroidNetWork

class OfficialPagingSource(private val cid : Int):BasePageSource() {

    override suspend fun getArticleList(page: Int): List<ArticleModel> {

        val articles_response = PlayAndroidNetWork.getWxArticle(page,cid)

        return articles_response.data.datas

    }

}