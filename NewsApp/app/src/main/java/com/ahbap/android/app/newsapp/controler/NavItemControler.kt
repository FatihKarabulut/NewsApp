package com.ahbap.android.app.newsapp.controler

enum class Routers{
    HOME,NewsSource,NEWS_SEARCH
}
sealed class NavItem(var router : String)
{
    object Home : NavItem(Routers.HOME.name)
    object NewsSource : NavItem(Routers.NewsSource.name)
    object News_Search : NavItem(Routers.NEWS_SEARCH.name)
}