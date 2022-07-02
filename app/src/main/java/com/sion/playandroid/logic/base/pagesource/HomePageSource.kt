package com.sion.playandroid.logic.base.pagesource

import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.network.PlayAndroidNetWork

// 参数类型为键值对
class HomePageSource:BasePageSource() {

    override suspend fun getArticleList(page: Int): List<ArticleModel> {

        val articles_response = PlayAndroidNetWork.getArticle(page)

        return articles_response.data.datas

    }


}