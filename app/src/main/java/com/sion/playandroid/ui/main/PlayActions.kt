package com.sion.playandroid.ui.main

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.utils.getHtmlText
import java.net.URLEncoder

class PlayActions(navController: NavHostController) {




    val enterArticle:(ArticleModel) -> Unit = {

        article ->

        article.desc = ""
        article.title = getHtmlText(article.title)
        val gson = Gson().toJson(article).trim()
        val result = URLEncoder.encode(gson, "utf-8")
        toAnimView(navController = navController, "${PlayDestinations.ARTICLE_ROUTE}/$result")

    }

    // 返回上一页
    val upPress:() -> Unit  = {

        navController.navigateUp()

    }


}