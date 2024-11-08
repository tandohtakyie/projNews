package com.example.projectnews.presentation.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.projectnews.domain.model.Article
import com.example.projectnews.util.Dimens.ARTICLE_CARD_SIZE
import com.example.projectnews.util.Dimens.PADDING5

@Composable
fun ArticleCard(
    modifier: Modifier,
    article: Article,
    context: Context,
    onCLick: () -> Unit
) {

    Row(
        modifier = modifier.clickable { onCLick() }
    ) {
        AsyncImage(
            modifier = modifier
                .size(ARTICLE_CARD_SIZE)
                .clip(shape = RoundedCornerShape(PADDING5)),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(

        ) {
            Text(
                text = article.title,
                fontWeight = FontWeight.Bold
            )

            Row {
                Text(text = article.source.name)
                Spacer(modifier = modifier.width(PADDING5))
                Text(text = article.publishedAt)
            }
        }

    }

}