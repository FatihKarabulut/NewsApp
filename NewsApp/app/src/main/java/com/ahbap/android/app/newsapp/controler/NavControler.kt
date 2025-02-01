package com.ahbap.android.app.newsapp.controler

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahbap.android.app.newsapp.activity.HomePage
import com.ahbap.android.app.newsapp.activity.NewsSearch
import com.ahbap.android.app.newsapp.activity.NewsSource


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavControler(modifier: Modifier,
                 nav : NavHostController = rememberNavController(),
                 startDestination : String = NavItem.Home.router
)
{
    NavHost(modifier = modifier, navController = nav,startDestination = startDestination)
    {
        composable(NavItem.Home.router){

            HomePage(nav)
        }
        composable("${NavItem.NewsSource.router}/{url}")
        {
            var url = it.arguments?.getString("url") ?: ""
            NewsSource(nav,url)
        }
        composable("${NavItem.News_Search.router}/{news}")
        {
            val str = it.arguments?.getString("news") ?: "Güncel"

            NewsSearch(nav,str)

        }
    }
}