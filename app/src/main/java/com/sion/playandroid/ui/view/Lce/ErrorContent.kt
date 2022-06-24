package com.sion.playandroid.ui.view.Lce

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sion.playandroid.R

@Composable
fun ErrorContent(modifier: Modifier = Modifier,
onErrorClick :() -> Unit){
    
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        
        Image(painter = painterResource(id = R.drawable.bad_network_image), 
            contentDescription = "网络请求失败",
        modifier = Modifier.padding(vertical = 50.dp))
        
        
        Button(onClick = onErrorClick) {
            
            Text(text = stringResource(id = R.string.bad_network_view_tip))
            
        }
        
    }
    
}