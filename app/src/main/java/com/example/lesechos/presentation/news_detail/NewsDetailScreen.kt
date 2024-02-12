package com.example.lesechos.presentation.news_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.lesechos.presentation.news_detail.composable.ArticleWebView
import com.example.lesechos.presentation.news_detail.composable.NewsDetailAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen( navController: NavController,
    viewModel: NewsDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NewsDetailAppBar(navController)
        },
        content = { innerPadding ->
            ArticleWebView(
                state.articleUrl,
                modifier = Modifier.padding(innerPadding)
            )
        }
    )

}
