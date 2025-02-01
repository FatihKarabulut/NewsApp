package com.ahbap.android.app.newsapp.activity

import android.annotation.SuppressLint
import android.util.Log
import android.webkit.WebView
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NewsSource(nav : NavHostController,url : String) {
    Log.d("NAVIGATION", "NewsSource Açıldı, URL: $url")

     AndroidView(
        factory = {view ->
            WebView(view).apply {
                settings.javaScriptEnabled = true
                loadUrl(url)
            }
        }
    )
}