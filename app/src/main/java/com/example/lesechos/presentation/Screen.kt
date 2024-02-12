package com.example.lesechos.presentation

sealed class Screen(val route: String) {
    object NewsListScreen: Screen("news_list_screen")
    object NewsDetailScreen: Screen("news_detail_screen")
}