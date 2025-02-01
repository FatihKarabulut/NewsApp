package com.ahbap.android.app.newsapp.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import com.ahbap.android.app.newsapp.news.INews
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class View @Inject constructor( val news: INews) : ViewModel() {

}