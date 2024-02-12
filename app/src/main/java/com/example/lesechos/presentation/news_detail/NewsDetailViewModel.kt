package com.example.lesechos.presentation.news_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.lesechos.common.Constants
import com.example.lesechos.common.Resource
import com.example.lesechos.presentation.news_list.NewsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(NewsDetailState())
    val state: State<NewsDetailState> = _state

    init {
        _state.value = NewsDetailState(isLoading = true)
        savedStateHandle.get<String>(Constants.PARAM_ARTICLE_URL)?.let { articleUrl ->
            articleUrl

            _state.value = NewsDetailState(articleUrl = articleUrl)

        }
    }

}