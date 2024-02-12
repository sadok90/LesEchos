package com.example.lesechos.domain.use_case

import com.example.lesechos.common.Resource
import com.example.lesechos.data.remote.dto.ArticleDto
import com.example.lesechos.data.remote.dto.toArticle
import com.example.lesechos.domain.model.Article
import com.example.lesechos.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.internal.http.HttpMethod
import retrofit2.HttpException
import retrofit2.http.HTTP
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(query : String) : Flow<Resource<List<Article>>> = flow {
        try {
            emit(Resource.Loading())
            val newsResponse = repository.getNews(query)
                if(newsResponse.status == "ok") {
                    if (newsResponse.articles.isEmpty()) {
                        emit(Resource.Error<List<Article>>( "No Data found"))
                    } else {
                        val articles = newsResponse.articles.map { it.toArticle() }
                        emit(Resource.Success<List<Article>>(articles))
                    }
                } else {//status error
                    emit(Resource.Error<List<Article>>(newsResponse.message ?: "Something went wrong"))
                }
        } catch (e: HttpException) {
            emit(Resource.Error<List<Article>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Article>>("Couldn't reach server. Check your internet connection"))
        }

    }
}