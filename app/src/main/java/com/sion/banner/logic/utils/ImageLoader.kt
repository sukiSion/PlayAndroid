package com.sion.bannerpagetest.banner.logic.utils

import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter

private const val TAG = "ImageLoader"

/**
 * 图片加载工具
 *
 * @param data 图片数据 可以为图片网址、本地地址或资源id
 * @param modifier 修饰符
 * @param contentScale 使用可选的scale参数来确定要使用的纵横比缩放
 */


@Composable
fun ImageLoader(

    data:Any?,

    modifier: Modifier = Modifier,

    contentScale :ContentScale = ContentScale.Crop

){

    // 使用when对data的数据类型进行判断
    // Int为本地图片
    // String为网络图片

    when(data){

        is String -> {

            val painter = if(data.contains("https://") || data.contains("http://")){

                Log.d(TAG, "PostCardPopular: 加载网络图片")

                rememberAsyncImagePainter(model = data)

            }else{

                Log.d(TAG,"PostCardPopular: 加载本地图片")

                val bitmap = BitmapFactory.decodeFile(data)

                BitmapPainter(bitmap.asImageBitmap())

            }
            
            Image(painter = painter,
                contentDescription = null,
                contentScale = contentScale,
                modifier = modifier

            )
            

        }


        is Int ->{

            Log.d(TAG, "PostCardPopular: 加载本地资源图片")

            Image(painter = painterResource(id = data),
                contentDescription = null,
            modifier = modifier,
            contentScale = contentScale

            )

        }

        else ->{

            throw IllegalArgumentException("参数类型不符合要求，只能是：url、文件路径或者是 drawable id")

        }

    }

}