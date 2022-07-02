package com.sion.playandroid.ui.page.mine

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sion.playandroid.logic.model.ArticleModel

@Composable
fun ProfileProperty(article:ArticleModel,enterArticle:(ArticleModel) -> Unit){

    Column(modifier = Modifier
        .clickable {

            enterArticle(article)

        }
        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {


        Divider()

        Text(text = article.title,
        modifier = Modifier.height(24.dp),
        style = MaterialTheme.typography.caption)

        Text(text = article.title,
        modifier = Modifier.height(24.dp),
        style = MaterialTheme.typography.body1)



    }

}