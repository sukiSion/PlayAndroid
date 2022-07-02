package com.sion.playandroid.ui.page.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import com.sion.playandroid.R
import com.sion.playandroid.logic.model.*
import com.sion.playandroid.ui.view.Lce.LcePage
import com.sion.playandroid.ui.view.PlayAppBar
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomePage(modifier: Modifier = Modifier,
             viewModel: HomePageViewModel = viewModel(),
             toArticleDetails: (ArticleModel) -> Unit){

    val bannerData by viewModel.bannerState.observeAsState(PlayLoading)

    var loadArticleState by rememberSaveable { mutableStateOf(false) }


    val lazyPagingItems = viewModel.articleResult.collectAsLazyPagingItems()

    if (!loadArticleState) {

        loadArticleState = true

        viewModel.getData()

    }


    viewModel.getData()
    
    Column(modifier = Modifier.fillMaxSize()) {
        
        PlayAppBar(title = stringResource(id = R.string.home_page),
        showBack = false)


        LcePage(playState = bannerData,

            onErrorClick = {

            viewModel.getData()

        }){

            val data = bannerData as PlaySuccess<List<BannerBean>>

           HomeContent(data = data.data,

               lazyPagingItems = lazyPagingItems,

               toArticleDetails = toArticleDetails)

        }
        
    }

}

