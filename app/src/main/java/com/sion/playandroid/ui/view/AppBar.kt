package com.sion.playandroid.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight


@Composable
fun PlayAppBar(

    title:String ,
    showBack:Boolean = true,
    click:(() -> Unit) ?= null,
    showRight:Boolean = false,
    rightImg :ImageVector = Icons.Rounded.MoreVert,
    rightClick:(() -> Unit) ?= null

){

    Column(modifier = Modifier.background(color =  MaterialTheme.colors.background)) {


        Spacer(modifier = Modifier.statusBarsHeight())

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(43.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {

            if(showBack && click!= null){

                IconButton(onClick = click!!,
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)) {

                    Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back")

                }

            }

            Text(text = title,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)

            if(rightClick != null && showRight){

                IconButton(onClick = rightClick!!,
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)) {

                    Icon(imageVector = rightImg, contentDescription = "more")

                }

            }



        }


    }


}


