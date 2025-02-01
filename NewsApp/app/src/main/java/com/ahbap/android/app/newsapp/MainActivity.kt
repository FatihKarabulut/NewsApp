package com.ahbap.android.app.newsapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ahbap.android.app.newsapp.controler.NavControler
import com.ahbap.android.app.newsapp.controler.NavItem
import com.ahbap.android.app.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.exp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            var nav : NavHostController = rememberNavController()
            var entryStack = nav.currentBackStackEntryAsState().value
            var show = entryStack?.destination?.route != NavItem.Home.router
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {topBars(nav,show)}) { innerPadding ->
                    NavControler(modifier = Modifier.padding(innerPadding),
                        nav = nav,
                        startDestination = NavItem.Home.router)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBars(nav: NavHostController, show: Boolean)
{
    var country by remember {
        mutableStateOf("")
    }

    TopAppBar(
        title = {Text("", style = TextStyle(
            color = Color.White,
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold


        ))
        },
        colors =  TopAppBarDefaults.topAppBarColors(colorResource(R.color.news)),
    )
    Row(modifier = Modifier.padding(top = 30.dp,
         start = 10.dp, end = 10.dp).background(colorResource(R.color.news)), horizontalArrangement = Arrangement.Center
        ,verticalAlignment = Alignment.CenterVertically) {


        if (show) {
            Image(
                modifier = Modifier.size(55.dp).padding(top = 10.dp)
                    .clickable {
                        nav.popBackStack()
                    },
                painter = painterResource(R.drawable.back),
                contentDescription = null,

                )
        }

        Spacer(modifier = Modifier.size(5.dp))

        Text(
            "${stringResource(R.string.Topapp_text_name)}\n${stringResource(R.string.Topapp_text_names)}",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,

                ),
            modifier = Modifier.padding(top = 5.dp),
        )


            TextField(
                value = country, onValueChange = { country = it },
                placeholder = {
                    Text(
                        stringResource(R.string.Topapp_text_search), style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Light

                        )
                    )
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                ),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White

                ),
                modifier = Modifier.weight(5f).height(50.dp).padding(start = 7.dp, end = 7.dp),
                shape = RoundedCornerShape(20.dp)


            )


            Button(modifier = Modifier.padding(start = 2.dp, top = 7.dp), onClick = {

                nav.navigate("${NavItem.News_Search.router}/$country")

            }) {
                Text(
                    text = stringResource(R.string.Topapp_button_search), style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
        }
    }







@Composable
fun GreetingPreview() {
    NewsAppTheme {

    }
}

@Composable
fun DropdownMenuItem(text: () -> Unit, onClick: () -> Unit) {
    TODO("Not yet implemented")
}