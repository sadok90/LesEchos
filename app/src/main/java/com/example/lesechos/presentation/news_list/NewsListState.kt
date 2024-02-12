package com.example.lesechos.presentation.news_list

import com.example.lesechos.domain.model.Article


data class NewsListState(
    val isLoading: Boolean = false,
    val news: List<Article> = emptyList(),
    val error: String = ""
)
