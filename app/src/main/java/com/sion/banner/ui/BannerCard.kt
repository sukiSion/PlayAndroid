package com.sion.bannerpagetest.banner.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.sion.bannerpagetest.banner.logic.model.BaseBannerBean
import com.sion.bannerpagetest.banner.logic.utils.ImageLoader
import java.lang.NullPointerException


/**
 * Banner 图片展示卡片
 *
 * @param bean banner Model
 * @param modifier
 * @param shape 图片圆角
 * @param contentScale 纵横比缩放
 * @param onBannerClick Banner 图片点击事件
 */

@Composable
fun <T : BaseBannerBean> BannerCard(

    bean:T,

    modifier: Modifier = Modifier,

    shape: Shape = RoundedCornerShape(10.dp),

    contentScale: ContentScale,

    onBannerClick: () -> Unit

){


    // 由于bean继承自BaseBannerBean
    // 所以.data是图片的网络url，本地图片
    if(bean.data == null) {

        throw NullPointerException("Url or image or filePath must have a not for empty.")

    }else{

        Card(shape = shape,
        modifier = modifier) {

            val imageModifier = Modifier.clickable(onClick = onBannerClick)

            ImageLoader(data = bean.data,
                modifier = imageModifier,
            contentScale = contentScale)

        }

    }

}