package com.sion.playandroid.ui.page.article

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.compose.LazyPagingItems
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.ui.page.article.list.ArticleItem

@Composable
fun ArticleListPaging(

    modifier: Modifier = Modifier,

    listState: LazyListState,

    lazyPagingItems: LazyPagingItems<ArticleModel>,

    enterArticle:(ArticleModel) -> Unit

){


    val context = LocalContext.current

    LazyColumn(modifier = modifier,
    state = listState){

        items(lazyPagingItems){

            ArticleItem(article)

        }

        val loasStatus = lazyPagingItems.loadState

    }

}