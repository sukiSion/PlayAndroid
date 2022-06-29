package com.sion.bannerpagetest.banner

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch
import java.util.*

/**
 *
 *  @param pageState 需要导入的谷歌库
 *   api "com.google.accompanist:accompanist-pager:$accompanist_version"
 *   api "com.google.accompanist:accompanist-pager-indicators:$accompanist_version"
 *   实验性方法
 *
 *
 * @param intervalTime
 *
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StartBanner(pageState:PagerState,intervalTime:Long){

    val coroutineScope = rememberCoroutineScope()

    val timer = Timer()

    val timerTask = object : TimerTask() {

        override fun run() {

            coroutineScope.launch {

                pageState.animateScrollToPage((pageState.currentPage + 1) % pageState.pageCount)

            }

        }

    }


    // 让timer执行timerTask
    timer.schedule(timerTask,intervalTime,intervalTime)



}