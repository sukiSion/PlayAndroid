package com.sion.playandroid.logic.network.service

import com.sion.playandroid.logic.model.ArticleListModel

import com.sion.playandroid.logic.model.BaseModel
import com.sion.playandroid.logic.model.ClassifyModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectService {

    @GET("project/tree/json")
    suspend fun getProjectTree():BaseModel<List<ClassifyModel>>

    @GET("project/list/{page}/json")
    suspend fun getProject(

        @Path("page") page:Int,
        @Query("cid") cid:Int

    ):BaseModel<ArticleListModel>

}