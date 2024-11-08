package com.example.projectnews.presentation.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.projectnews.domain.model.Article
import com.example.projectnews.util.Dimens.PADDING5

@Composable
fun handlePagingResult(articles: LazyPagingItems<Article>, modifier: Modifier): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect(
                modifier = modifier
            )
            false
        }

        error != null -> {
            EmptyScreen(error = error, modifier = modifier)
            false
        }

        else -> {
            true
        }

    }
}

@Composable
fun ShimmerEffect(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(PADDING5)
    ) {
        repeat(10) {
            ArticleCardShimmer(modifier = modifier.padding(horizontal = PADDING5))
        }
    }
}

@Composable
fun ArticleList(
    modifier: Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit,
    context: Context,
) {
    val handlePagingResult = handlePagingResult(articles = articles, modifier = modifier)
    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(PADDING5),
            contentPadding = PaddingValues(all = PADDING5),
        ) {
            items(count = articles.itemCount) {
                articles[it]?.let { article ->
                    ArticleCard(
                        modifier = modifier,
                        article = article,
                        context = context,
                        onCLick = { onClick(article) }
                    )
                }
            }
        }
    }
}
