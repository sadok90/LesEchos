package com.example.lesechos.presentation.news_detail

data class NewsDetailState(
    val isLoading: Boolean = false,
    val articleUrl: String = "null",
    val error: String = ""
)