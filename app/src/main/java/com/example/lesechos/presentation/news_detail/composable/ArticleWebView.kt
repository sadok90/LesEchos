package com.example.lesechos.presentation.news_detail.composable

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ArticleWebView(url : String, modifier: Modifier) {
    val isLoading = remember { mutableStateOf(false) }
    val webViewUrl = remember { mutableStateOf(url) }

    Box(modifier = modifier) {
        AndroidView(
            modifier = modifier,
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.setSupportZoom(true)
                    webViewClient = object : WebViewClient() {
                        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                            super.onPageStarted(view, url, favicon)
                            // show dialog
                            isLoading.value = true
                        }

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            // hide dialog
                            isLoading.value = false
                        }
                    }
                }

            },
            update = { webView ->
                webView.loadUrl(webViewUrl.value)
            }
        )
        if(isLoading.value) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
