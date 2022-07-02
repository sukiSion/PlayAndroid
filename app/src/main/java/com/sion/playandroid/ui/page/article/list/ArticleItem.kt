package com.sion.playandroid.ui.page.article.list

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sion.playandroid.logic.model.ArticleModel

@Composable
fun ArticleItem(

    article:ArticleModel?,

    enterArticle:(urlArgs:ArticleModel) -> Unit

){

    if(article == null) return

        ArticleListItem(
        article = article,
        onClick = { enterArticle(article) },
        modifier = Modifier.height(96.dp).padding(start = 16.dp, top = 8.dp),
        shape = RoundedCornerShape(topStart = 24.dp)
    )

//    NewArticleListItem(article = article) {
//
//        enterArticle(article)
//
//
//    }


}