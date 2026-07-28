package io.github.bagascahyawiguna.showcase.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun DetailLoadingView(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
                .clip(RoundedCornerShape(16.dp))
                .shimmerBackground()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .height(32.dp)
                .fillMaxWidth(0.6f)
                .clip(RoundedCornerShape(8.dp))
                .shimmerBackground()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth(0.3f)
                .clip(RoundedCornerShape(4.dp))
                .shimmerBackground()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth(0.35f)
                .clip(RoundedCornerShape(6.dp))
                .shimmerBackground()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .shimmerBackground()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth(0.95f)
                .clip(RoundedCornerShape(4.dp))
                .shimmerBackground()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(4.dp))
                .shimmerBackground()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(16.dp)
                .fillMaxWidth(0.6f)
                .clip(RoundedCornerShape(4.dp))
                .shimmerBackground()
        )
    }
}
