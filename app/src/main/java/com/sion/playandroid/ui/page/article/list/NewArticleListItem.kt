package com.sion.playandroid.ui.page.article.list

import android.text.TextUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sion.playandroid.R
import com.sion.playandroid.logic.model.ArticleModel
import com.sion.playandroid.logic.utils.getHtmlText
import com.zj.banner.utils.ImageLoader

@Composable
fun NewArticleListItem(

    article: ArticleModel,

    modifier: Modifier = Modifier,

    onClick:()->Unit

){

    val hasImage = article.envelopePic.isNotBlank()

    Card(modifier = modifier
        .padding(horizontal = 10.dp, vertical = if (hasImage) 7.dp else 5.dp)
        .fillMaxWidth()
        .height(if (hasImage) 90.dp else 70.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(modifier = Modifier
            .background(

                brush = Brush.linearGradient(

                    arrayListOf(

                        colorResource(id = R.color.article_item_bg_start),

                        colorResource(id = R.color.article_item_bg_mid),

                        colorResource(id = R.color.article_item_bg_end)

                    )

                )

            )
            .clickable(onClick = onClick)
        ) {

            if(hasImage){

                ImageLoader(data = article.envelopePic,
                    modifier = Modifier.aspectRatio(1f)
                )

            }
            
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {

                Text(text = getHtmlText(article.title),
                style = MaterialTheme.typography.subtitle1,
                maxLines = if (hasImage) 2 else 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(Alignment.Top))

                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(Alignment.Bottom),
                verticalAlignment = Alignment.CenterVertically) {

                    Text(text = article.superChapterName,
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start))
                    
                    Text(text = if(TextUtils.isEmpty(article.author)) article.shareUser else article.author,
                        style = MaterialTheme.typography.caption,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f)
                            .wrapContentWidth(Alignment.Start)
                        )

                }

            }

        }

    }

}