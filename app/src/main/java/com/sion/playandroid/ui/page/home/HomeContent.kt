package com.sion.playandroid.ui.page.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.sion.bannerpagetest.banner.ui.BannerPager
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.model.BannerBean
import com.sion.playandroid.ui.page.article.ArticleListPaging

@Composable
fun HomeContent(

    data: List<BannerBean>,
    lazyPagingItems: LazyPagingItems<ArticleModel>,
    toArticleDetails: (ArticleModel) -> Unit

){

    val listState = rememberLazyListState()
    Column(modifier =  Modifier.fillMaxSize()) {
    
    BannerPager(
        items = data,
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(15.dp)
    ) {
        toArticleDetails(
            ArticleModel(
                title = it.title,
                link = it.url
            )
        )
    }
        ArticleListPaging(
            modifier = Modifier.weight(2f),
            listState,
            lazyPagingItems,
        enterArticle = toArticleDetails)

    }

}