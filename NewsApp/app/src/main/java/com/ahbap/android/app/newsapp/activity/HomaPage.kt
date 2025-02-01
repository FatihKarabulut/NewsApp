package com.ahbap.android.app.newsapp.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.newsapp.news.Article
import com.ahbap.android.app.newsapp.viewModel.View
import java.time.LocalDate

const val _GUNCEL = "Güncel"
const val _HOME_PAGE_API = "eb904157363b481c95aa48121c7414ea"



@Composable
fun HomePage(nav: NavHostController,viewModel: View = hiltViewModel()) {

    var list by remember {
        mutableStateOf(emptyList<Article>())
    }

    list = NewsCity(_GUNCEL, LocalDate.now().minusDays(2).toString(),_HOME_PAGE_API)

    if (list.isEmpty())
        Column(modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(Color.White)
            ) {

            Text("Haberler Bulunmuyor", style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
            ))

        }

        }

    else
    {
        NewsCard(nav,list)


    }

}

