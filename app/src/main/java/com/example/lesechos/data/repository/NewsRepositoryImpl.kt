package com.example.lesechos.data.repository

import com.example.lesechos.data.remote.NewsApi
import com.example.lesechos.data.remote.dto.NewsResponse
import com.example.lesechos.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getNews(query: String): NewsResponse {
        return api.getNews(query)
    }

}