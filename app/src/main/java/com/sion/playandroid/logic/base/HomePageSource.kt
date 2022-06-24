package com.sion.playandroid.logic.base

import androidx.paging.PagingSource
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.model.ArticleListModel
import com.sion.playandroid.logic.network.PlayAndroidNetWork
import java.lang.Exception

// 参数类型为键值对
class HomePageSource:BasePageSource() {

    override suspend fun getArticleList(page: Int): List<ArticleModel> {

        val articles_response = PlayAndroidNetWork.getArticle(page)

        return articles_response.data.datas

    }


}