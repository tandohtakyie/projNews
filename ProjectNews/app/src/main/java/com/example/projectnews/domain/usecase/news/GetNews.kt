package com.example.projectnews.domain.usecase.news

import androidx.paging.PagingData
import com.example.projectnews.domain.model.Article
import com.example.projectnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}