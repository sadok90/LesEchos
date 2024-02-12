package com.example.lesechos.domain.repository

import com.example.lesechos.data.remote.dto.NewsResponse

interface NewsRepository {
    suspend fun getNews(query: String) : NewsResponse
}