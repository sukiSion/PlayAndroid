package com.sion.playandroid.ui.main

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sion.playandroid.logic.model.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sion.playandroid.ui.page.home.HomePage
import java.util.*

@ExperimentalStdlibApi
@Composable
// 使用viewModel()自动帮我们创建该数据模型
fun MainPage(actions: PlayActions,viewModel: HomeViewModel = viewModel()) {

    val position by viewModel.position.observeAsState()

    // 获取这个枚举类的所有值
    val tabs = CourseTabs.values()

    Scaffold(backgroundColor = MaterialTheme.colors.background,
    bottomBar = {

        BottomNavigation {

            // 遍历这个枚举类的所有值
            tabs.forEach {

                tab ->

                BottomNavigationItem(selected = tab == position,
                    onClick = {

                    viewModel.onPositionChange(tab)

                },
                modifier = Modifier.background(MaterialTheme.colors.primary),
                icon = {

                    Icon(painter = painterResource(id = tab.icon), contentDescription = null)

                },
                label = {


                    Text(text = stringResource(id = tab.title).uppercase(Locale.ROOT))
                },
                alwaysShowLabel = true)

            }

        }

    }) {

        innerPadding ->

        val modifier = Modifier.padding(innerPadding)

        // 淡入淡出的布局动画
        Crossfade(targetState = position) {

            when(it){

                CourseTabs.HOME_PAGE -> HomePage(actions = actions, modifier = modifier)


            }


        }

    }


}