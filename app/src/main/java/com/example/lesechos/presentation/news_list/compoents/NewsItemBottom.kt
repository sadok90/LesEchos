package com.example.lesechos.presentation.news_list.compoents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.lesechos.domain.model.Article

@Composable
fun NewsItemBottom(article: Article) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .alpha(0.5f)
        .background(color = MaterialTheme.colorScheme.background)
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        VerticalTextWithLabel(label = "Author :", value = article.author, Modifier.weight(3f))
        VerticalTextWithLabel(label = "Source :", value = article.source, Modifier.weight(3f))
        VerticalTextWithLabel(label = "Date :", value = article.publishedAt, Modifier.weight(2f))
    }
}

