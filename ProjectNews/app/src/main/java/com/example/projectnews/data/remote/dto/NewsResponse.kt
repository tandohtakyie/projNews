package com.example.projectnews.data.remote.dto

import com.example.projectnews.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)