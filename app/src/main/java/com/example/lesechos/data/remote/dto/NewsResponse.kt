package com.example.lesechos.data.remote.dto
data class NewsResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int,
    val code: String?,
    val message: String?
)