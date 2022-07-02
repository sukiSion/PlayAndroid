package com.sion.playandroid.ui.page.mine

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sion.playandroid.R
import com.sion.playandroid.logic.model.ArticleModel


@Composable
fun UserInfoFields(enterArticle:(ArticleModel) -> Unit) {
    
    Text(text = "Sion",
    modifier = Modifier.height(32.dp),
    style = MaterialTheme.typography.h5)
    
    Text(text = stringResource(id = R.string.telephone),
    modifier = Modifier
        .padding(bottom = 20.dp)
        .height(24.dp),
    style = MaterialTheme.typography.body1)

    ProfileProperty(
        ArticleModel(
            title = stringResource(R.string.mine_blog),
            link = "https://zhujiang.blog.csdn.net/"
        ),
        enterArticle
    )

    ProfileProperty(
        ArticleModel(
            title = stringResource(R.string.mine_nuggets),
            link = "https://juejin.im/user/5c07e51de51d451de84324d5"
        ),
        enterArticle
    )

    ProfileProperty(
        ArticleModel(
            title = stringResource(R.string.mine_github),
            link = "https://github.com/zhujiang521"
        ),
        enterArticle
    )
    
}