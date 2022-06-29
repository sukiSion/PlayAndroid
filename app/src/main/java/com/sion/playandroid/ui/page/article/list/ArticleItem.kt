package com.sion.playandroid.ui.page.article.list

import androidx.compose.runtime.Composable
import com.sion.playandroid.logic.model.ArticleModel

@Composable
fun ArticleItem(

    article:ArticleModel?,

    enterArticle:(urlArgs:ArticleModel) -> Unit

){

    if(article == null) return



}