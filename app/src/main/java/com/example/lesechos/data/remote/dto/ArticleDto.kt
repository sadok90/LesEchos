package com.example.lesechos.data.remote.dto

import com.example.lesechos.common.DateUtils
import com.example.lesechos.domain.model.Article
import java.util.Date

data class ArticleDto(
    val author: String?,
    val content: String,
    val description: String?,
    val publishedAt: Date,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?
)
fun ArticleDto.toArticle() : Article{
    return Article(
        author = this.author ?: "",
        content = this.content,
        description = this.description ?: "",
        publishedAt = DateUtils.toSimpleString(this.publishedAt),
        source = this.source.name,
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage ?: ""
    )
}