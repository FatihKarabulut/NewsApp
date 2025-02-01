package com.ahbap.android.app.newsapp.news

import kotlinx.serialization.Serializable


data class NewsSearch ( var status: String? = null,
                        var totalResults: Int = 0,
                        var articles: List<Article> = emptyList()) {

}