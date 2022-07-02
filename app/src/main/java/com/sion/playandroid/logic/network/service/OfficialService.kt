package com.sion.playandroid.logic.network.service

import com.sion.playandroid.logic.model.ArticleListModel
import com.sion.playandroid.logic.model.BaseModel
import com.sion.playandroid.logic.model.ClassifyModel
import retrofit2.http.GET
import retrofit2.http.Path

interface OfficialService {

    @GET("wxarticle/chapters/json")
    suspend fun getWxArticleTree():BaseModel<List<ClassifyModel>>

    @GET("wxarticle/list/{cid}/{page}/json")
    suspend fun getWxArticle(@Path("page") page:Int,@Path("cid") cid:Int):BaseModel<ArticleListModel>

}