package com.sion.playandroid.ui.page.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sion.playandroid.R
import com.sion.playandroid.ui.main.PlayActions


@Composable
fun ProfilePage(action:PlayActions) {
    
    Column(modifier =  Modifier.fillMaxSize()) {
        
        Image(painter = painterResource(id = R.drawable.img_head),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth())
        
        UserInfoFields(enterArticle = action.enterArticle)
        
    }
    
}