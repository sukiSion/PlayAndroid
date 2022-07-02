package com.sion.playandroid.logic.base.pagesource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sion.playandroid.logic.model.ArticleModel
import java.lang.Exception

abstract class BasePageSource:PagingSource<Int,ArticleModel>() {

    abstract suspend fun getArticleList(page:Int):List<ArticleModel>

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleModel> {

        return try{

            val page = params.key ?: 1

            val articleList = getArticleList(page)

            val prevKey = if (page > 1) page -1 else null

            val nextKey = if(articleList.isNotEmpty()) page + 1 else null

            LoadResult.Page(data = articleList,prevKey = prevKey,nextKey = nextKey)

        }catch (e:Exception){

            LoadResult.Error(e)

        }

    }

    override fun getRefreshKey(state: PagingState<Int, ArticleModel>): Int? = null

}