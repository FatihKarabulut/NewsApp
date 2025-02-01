package com.ahbap.android.app.newsapp.activity


import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.newsapp.news.Article
import com.ahbap.android.app.newsapp.news.NewsSearch
import com.ahbap.android.app.newsapp.viewModel.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate




@Composable
fun NewsCity(
             country: String = "Türkiye", date : String = LocalDate.now().minusDays(1).toString(),
             apikey : String = "bff53fed113b400eba876ec416dbcd5e",
             viewModel: View = hiltViewModel()) : List<Article> {
    var list by remember {
        mutableStateOf(emptyList<Article>())
    }


    var call = viewModel.news.create(city = country,
        date = date,
        apikey = apikey)
    call.enqueue(object : Callback<NewsSearch>{
        override fun onResponse(call: Call<NewsSearch>, response: Response<NewsSearch>) {

            if (response.isSuccessful)
                list = response.body()!!.articles
        }
        override fun onFailure(call: Call<NewsSearch?>, t: Throwable) {
            Log.e("NewsCity","onFailure ")
        }
    })

    return list

}

