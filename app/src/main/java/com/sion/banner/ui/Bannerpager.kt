package com.sion.bannerpagetest.banner.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.sion.bannerpagetest.banner.StartBanner
import com.sion.bannerpagetest.banner.logic.model.BannerConfig
import com.sion.bannerpagetest.banner.logic.model.BaseBannerBean

import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.absoluteValue


private const val TAG = "BannerPager"

/**
 * 新增一个 Banner，最简单的情况下只需传入数据即可，如果需要更多样式请查看下面参数。
 * 这里需要注意的是，数据 Model 必须要继承自 [BaseBannerBean]，因为在 [BannerCard] 中需要使用到其中的一些参数
 *
 * @param items 数据
 * @param config Banner 的一些配置参数 [BannerConfig]
 * @param indicatorIsVertical 指示器是否为竖向
 * @param indicatorGravity Banner 指示器位置，直接使用 Alignment 即可进行设定
 * @param onBannerClick Banner 点击事件的回调
 * @param modifier BannerPager修饰符
 */

@Composable
@OptIn(ExperimentalPagerApi::class)
fun <T: BaseBannerBean> BannerPager(

    items:List<T> = arrayListOf(),

    // repeat : Boolean = true,

    modifier: Modifier = Modifier,

    config : BannerConfig = BannerConfig(),

    indicatorIsVertical: Boolean = false,

    indicatorGravity: Alignment = Alignment.BottomCenter,

    onBannerClick: (T) -> Unit

){

    if(items.isEmpty()){

        throw NullPointerException("items is not null")

    }

    val pagerState = rememberPagerState()

    if(config.repeat){


        StartBanner(pageState = pagerState, intervalTime = config.intervalTime)

    }


    Box(modifier = modifier.height(config.bannerHeight)){
        
        HorizontalPager(
            count = items.size,
            state = pagerState,
            itemSpacing = config.itemSpacing,
            contentPadding = config.contentPadding
            ) {

            page ->

            val item = items[page]

            BannerCard(bean = item, modifier = Modifier
                .graphicsLayer {

                    // 计算当前页面相对于滚动位置的绝对偏移量。我们使用绝对值，它允许我们镜像两个方向的任何效果
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                }
                .fillMaxSize()
                .padding(config.bannerImagePadding),
            shape = config.shape,
            contentScale = config.contentScale) {

                Log.d(TAG,"item is ${item.javaClass}")

                onBannerClick(item)

            }


        }

        if(indicatorIsVertical){

            VerticalPagerIndicator(pagerState = pagerState,
            modifier = Modifier
                .align(indicatorGravity)
                .padding(16.dp))

        }else {

            HorizontalPagerIndicator(pagerState = pagerState,
            modifier = Modifier
                .align(indicatorGravity)
                .padding(16.dp))

        }
        
    }

}


