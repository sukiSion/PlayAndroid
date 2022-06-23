package com.sion.playandroid.ui.main

import androidx.navigation.NavController
import com.google.gson.Gson
import com.sion.playandroid.logic.model.ArticleModel
import java.net.URLEncoder

class PlayActions(navController: NavController) {


    val enterArticle:(ArticleModel) -> Unit = {

        article ->

        article.desc = ""

//        article.title =

        // 转为Json字符串
        val gson = Gson().toJson(article).trim()

        // 更改字符编码
        val  result = URLEncoder.encode(gson,"utf-8")

        navController.navigate("${PlayDestinations.ARTICLE_ROUTE}/$result")

    }

    // 返回上一页
    val upPress:() -> Unit  = {

        navController.navigateUp()

    }


}