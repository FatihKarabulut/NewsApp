package com.ahbap.android.app.newsapp.activity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ahbap.android.app.newsapp.controler.NavItem
import com.ahbap.android.app.newsapp.news.Article
import okio.Utf8
import java.net.URLEncoder

@Composable
fun NewsCard(nav : NavHostController,list : List<Article>) {
    Column( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn{
            items(list)
            {

                Card(modifier = Modifier.fillMaxSize(), elevation = CardDefaults.cardElevation(10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(Color.White))
                {

                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {



                        Image(modifier = Modifier.size(400.dp).padding(top = 15.dp),
                            contentScale = ContentScale.Crop
                            ,painter = rememberAsyncImagePainter(it.urlToImage.toString())
                            , contentDescription = null)

                        Text("${it.title}",style = TextStyle(
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.ExtraBold
                        ), modifier = Modifier.padding(10.dp))

                        Text("${it.description}",style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Medium
                        ), modifier = Modifier.padding(10.dp))


                    }
                    Button(onClick = {
                        Log.e("CARDs", it.url.toString())
                        var encode = URLEncoder.encode(it.url.toString(), "UTF-8")
                        Log.e("ENCODE", encode)
                        nav.navigate("${NavItem.NewsSource.router}/${encode}")
                    }) {
                        Text("Haberi Oku",style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Medium))
                    }
                }

                Spacer(modifier = Modifier.padding(10.dp))
            }

        }



    }
}
