package com.sion.playandroid.logic.network.service

import com.sion.playandroid.logic.model.ArticleListModel
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.model.BannerBean
import com.sion.playandroid.logic.model.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path


interface HomePageService {

    @GET("banner/json")
    suspend fun getBanner():BaseModel<List<BannerBean>>

    @GET("article/list/{page}/json")
    suspend fun getArticle(@Path("page")page:Int):BaseModel<ArticleListModel>

}