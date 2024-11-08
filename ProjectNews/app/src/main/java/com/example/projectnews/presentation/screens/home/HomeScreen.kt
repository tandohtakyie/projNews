package com.example.projectnews.presentation.screens.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.projectnews.R
import com.example.projectnews.domain.model.Article
import com.example.projectnews.presentation.components.ArticleList
import com.example.projectnews.presentation.components.SearchBar
import com.example.projectnews.presentation.navgraph.Route
import com.example.projectnews.util.Dimens.PADDING5

@Composable
fun HomeScreen(
    modifier: Modifier,
    articles: LazyPagingItems<Article>,
    navigate: (String) -> Unit,
    context: Context,
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = PADDING5)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = modifier
                .width(100.dp)
                .height(30.dp)
                .padding(horizontal = PADDING5)
        )

        Spacer(modifier = modifier.height(PADDING5))

        SearchBar(
            modifier = modifier.padding(horizontal = PADDING5),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = {
                navigate(Route.SearchScreen.route)
            }
        )

        Spacer(modifier = modifier.height(PADDING5))

        Text(
            text = titles,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = PADDING5)
                .basicMarquee(),
            color = Color.Magenta
        )

        Spacer(modifier = modifier.height(PADDING5))

        ArticleList(
            modifier = modifier.padding(horizontal = PADDING5),
            articles = articles,
            onClick = {
                navigate(Route.DetailScreen.route)
            },
            context = context,
        )
    }
}