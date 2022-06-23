package com.sion.playandroid.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.ui.main.PlayDestinations.ARTICAL_ROUTE_URL
import com.sion.playandroid.ui.page.article.ArticlePage

@Composable
@ExperimentalStdlibApi
fun NavGraph(startDestination: String = PlayDestinations.HOME_PAGE_ROUTE){

    val navController = rememberNavController()

    // 记住页面的跳转行为
    val actions = remember(navController) {

        PlayActions(navController)

    }

    // 这里就可以设置NavHost了
    NavHost(navController = navController,
    startDestination = startDestination){

        // NavGraph构建器

        // 注册页面
        composable(PlayDestinations.HOME_PAGE_ROUTE){

            MainPage(actions)

        }

        composable("${PlayDestinations.ARTICLE_ROUTE}/{$ARTICAL_ROUTE_URL}",
        arguments = listOf(

            navArgument(ARTICAL_ROUTE_URL){ type = NavType.StringType }

        )){

            backStackEntry ->

            val arguments = requireNotNull(backStackEntry.arguments)

            val parcelable = arguments.getString(ARTICAL_ROUTE_URL)

            val fromJson = Gson().fromJson(parcelable,ArticleModel::class.java)

            ArticlePage(fromJson){

                actions.upPress

            }

        }

    }

}