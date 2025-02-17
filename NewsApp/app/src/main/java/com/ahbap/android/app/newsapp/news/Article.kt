package com.ahbap.android.app.newsapp.news

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
class Article {
    var source: Source? = null
    var author: String? = null
    var title: String? = null
    var description: String? = null
    var url: String? = null
    var urlToImage: String? = null
    @Contextual
    var publishedAt: Date? = null
    var content: String? = null
}