package com.sion.playandroid.ui.page.article

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sion.playandroid.logic.model.ClassifyModel
import com.sion.playandroid.logic.utils.getHtmlText


@Composable
fun ArticleTabRow(

    position: Int?,

    data: List<ClassifyModel>,

    onTabClick: (Int,Int,Boolean)->Unit

) {

    ScrollableTabRow(selectedTabIndex = position ?: 0,

        modifier = Modifier.wrapContentWidth(),

        edgePadding = 3.dp

        ) {

        data.forEachIndexed { index, classifyModel ->

            Tab(
                selected = position == index,

                text = {

                    Text(text = getHtmlText(classifyModel.name))

                },

                onClick = {

                    onTabClick(index, classifyModel.id, false)

                },
            )

        }

        onTabClick(0,data[position?:0].id,true)

    }

}