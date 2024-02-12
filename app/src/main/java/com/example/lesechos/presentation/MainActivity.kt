package com.example.lesechos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lesechos.presentation.Screen
import com.example.lesechos.presentation.news_detail.NewsDetailScreen
import com.example.lesechos.presentation.news_list.NewsListScreen
import com.example.lesechos.presentation.ui.theme.LesEchosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LesEchosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BodyContent()
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BodyContent(modifier: Modifier = Modifier) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Screen.NewsListScreen.route,
            modifier = modifier
        ) {
            composable(
                route = Screen.NewsListScreen.route
            ) {
                NewsListScreen(navController)
            }
            composable(
                route = Screen.NewsDetailScreen.route + "/{articleUrl}"
            ) {
                NewsDetailScreen(navController)
            }
        }
    }


}