package com.sion.playandroid.ui.page.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.utils.Toast
import com.sion.playandroid.ui.page.article.list.ArticleItem
import com.sion.playandroid.ui.view.Lce.ErrorContent
import com.sion.playandroid.ui.view.Lce.LoadingContent

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

            article ->

            ArticleItem(article = article){

                enterArticle(it)

            }

        }

        // 获取分页加载状态
        val loadStatus = lazyPagingItems.loadState

        /**
         *
         * 下面为处理Paging不同的加载状态
         *
         */

        when{

            // 刷新的时候全屏出现加载图片
            loadStatus.refresh is LoadState.Loading ->{

                item {

                    LoadingContent(modifier = Modifier.fillParentMaxSize())

                }

            }

            // 追加的时候部分加载
            loadStatus.append is LoadState.Loading ->{

                item {

                    LoadingContent()

                }

            }

            loadStatus.refresh is LoadState.Error ->{

                val e = lazyPagingItems.loadState.refresh as LoadState.Error

                Toast.showToast(context, text = e.error.localizedMessage?:"")

                item {

                    ErrorContent(modifier = Modifier.fillParentMaxSize()) {

                        lazyPagingItems.retry()

                    }

                }
            }
            
            loadStatus.append is LoadState.Error ->{
                
                val e = lazyPagingItems.loadState.append as LoadState.Error
                
                Toast.showToast(context, text = e.error.localizedMessage?:"")
                
                item { 
                    
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                        
                        Button(onClick = { 
                            
                            lazyPagingItems.retry()
                            
                        }) {
                            
                            Text(text = "Retry")
                            
                        }
                        
                    }
                    
                }
                
            }
            

        }


    }

}