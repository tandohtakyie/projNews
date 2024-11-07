package com.example.projectnews.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projectnews.ui.theme.PrimaryColor
import com.example.projectnews.ui.theme.WhiteColor
import com.example.projectnews.util.Dimens.PADDING5

@Composable
fun NewsButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor,
            contentColor = WhiteColor,
        ),
        shape = RoundedCornerShape(PADDING5)
    ) {
        Text(text = text)
    }
}