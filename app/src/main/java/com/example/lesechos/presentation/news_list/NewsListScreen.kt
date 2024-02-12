package com.example.lesechos.presentation.news_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.lesechos.domain.model.Article
import com.example.lesechos.presentation.Screen
import com.example.lesechos.presentation.news_list.compoents.NewsListItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun NewsListScreen(
    navController: NavController,
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            BodyContent(navController, state, modifier = Modifier.padding(innerPadding))
        },
        topBar = { ListNewsAppBar(viewModel, navController) },


    )

}

@Composable
fun BodyContent(navController: NavController, state: NewsListState, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.news) { article ->
                NewsListItem(article = article, onItemClick = {
                    val encodedUrl = URLEncoder.encode(it.url, StandardCharsets.UTF_8.toString())
                    navController.navigate(Screen.NewsDetailScreen.route + "/$encodedUrl")
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListNewsAppBar(viewModel: NewsListViewModel, navController: NavController) {
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val searchList by viewModel.searchList.collectAsState()


    SearchBar(
        query = searchText,//text showed on SearchBar
        onQueryChange = viewModel::onSearchTextChange, //update the value of searchText
        onSearch = viewModel::onSearchTextChange, //the callback to be invoked when the input service triggers the ImeAction.Search action
        active = isSearching, //whether the user is searching or not
        onActiveChange = { viewModel.onToogleSearch() }, //the callback to be invoked when this search bar's active state is changed
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        SearchContent(navController = navController, searchList = searchList)
    }
}

@Composable
fun SearchContent(navController: NavController, searchList: List<Article>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(searchList) { article ->
                NewsListItem(article = article, onItemClick = {
                    val encodedUrl = URLEncoder.encode(it.url, StandardCharsets.UTF_8.toString())
                    navController.navigate(Screen.NewsDetailScreen.route + "/$encodedUrl")
                })
            }
        }
    }
}