package com.ahbap.android.app.newsapp.news

import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val Url = "https://newsapi.org/"
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModel {

    @Provides
    fun createNews(retrofit: Retrofit) : INews= retrofit.create(INews::class.java)

    @Provides
    fun createRetrofit() : Retrofit
    {
        var base = OkHttpClient.Builder().build()
        var gson = GsonConverterFactory.create(GsonBuilder().setLenient().create())
        return Retrofit.Builder().baseUrl(Url).addConverterFactory(gson)
            .client(base).build()

    }

}