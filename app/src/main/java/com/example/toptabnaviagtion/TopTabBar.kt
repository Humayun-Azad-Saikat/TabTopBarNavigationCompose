package com.example.toptabnaviagtion

import android.net.http.SslCertificate.saveState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import com.example.toptabnaviagtion.navigation.NavigationHost
import com.example.toptabnaviagtion.navigation.ScreenDestination

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopTabBar(){

    val tabItems = listOf(
        TabItem(
            title = "Home",
            Icons.Filled.Home,
            Icons.Outlined.Home,
            route = ScreenDestination.HomeScreen
        ) ,
        TabItem(
            title = "Edit",
            Icons.Filled.Edit,
            Icons.Outlined.Edit,
            route = ScreenDestination.EditScreen
        ),
        TabItem(
            title = "Account",
            Icons.Filled.AccountBox,
            Icons.Outlined.AccountBox,
            route = ScreenDestination.AccountScreen
        )
    )

    val navController = rememberNavController()
    var selectedTabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState { tabItems.size }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed{index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index

                        // Navigate to the corresponding screen on tab click
                        navController.navigate(tabItem.route) {
                            popUpTo(navController.graph.id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }



                    },
                    text = {
                        Text(tabItem.title)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex) tabItem.selectedIcon else tabItem.unSelectedIcon,
                            contentDescription = tabItem.title
                        )
                    }

                )
            }
        }


        //if i want to make tab row swipeable
        HorizontalPager(
            pagerState,
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {index->

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(tabItems[index].title)
                NavigationHost(navController)

            }

        }

        LaunchedEffect(selectedTabIndex) { //for click on icon to change page animation (just for animation)
            pagerState.animateScrollToPage(selectedTabIndex)

        }
        LaunchedEffect(pagerState.targetPage) { //for swipe page and change icon together
            selectedTabIndex = pagerState.targetPage

            // Navigate to the corresponding screen on swapping
            navController.navigate(tabItems[pagerState.targetPage].route) {
                popUpTo(navController.graph.id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

        }


    }

}


//special notes:
// if i have lot of tabs then i can use: ScrollableTabRow. this is as same as TabRow

//i cant create companion object here

data class TabItem(
    val title:String,
    val selectedIcon:ImageVector,
    val unSelectedIcon:ImageVector,
    val route: ScreenDestination
)