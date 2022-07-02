package com.sion.playandroid.ui.page.project


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.insets.statusBarsHeight
import com.sion.playandroid.logic.model.*
import com.sion.playandroid.ui.page.article.ArticleListPaging
import com.sion.playandroid.ui.page.article.ArticleTabRow
import com.sion.playandroid.ui.view.Lce.LcePage


@Composable
fun ProjectPage(

    modifier: Modifier,

    enterArticle:(ArticleModel) ->Unit,

    viewModel: ProjectViewModel = viewModel()

) {

    val lazyPagingItems = viewModel.articleResult.collectAsLazyPagingItems()

    val tree by viewModel.treeLiveData.observeAsState(PlayLoading)

    val position by viewModel.position.observeAsState(0)

    var loadPageState by rememberSaveable { mutableStateOf(false) }

    var loadState by rememberSaveable { mutableStateOf(false) }

    if(!loadState){

        loadState = true

        viewModel.getDataList()

    }

    Column(modifier = Modifier.background(color = MaterialTheme.colors.primary)) {

        Spacer(modifier = Modifier.statusBarsHeight())

        LcePage(playState = tree,

            onErrorClick = {

                viewModel.getDataList()

                loadState = true

            }) {

            val data = (tree as PlaySuccess<List<ClassifyModel>>).data

            ArticleTabRow(position = position, data = data){

                index, id ,isFirst ->

                if(!isFirst){

                    viewModel.searchArticle(Query(id))

                    viewModel.onPositionChanged(index)

                }else{

                    if(position == 0) {

                        viewModel.searchArticle(Query(id))

                    }

                }

                loadPageState = true

            }

            ArticleListPaging(modifier = modifier,
                listState = rememberLazyListState(),
                lazyPagingItems = lazyPagingItems,
                enterArticle = enterArticle)

        }

    }


}