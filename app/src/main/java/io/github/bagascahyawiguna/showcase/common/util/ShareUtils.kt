package io.github.bagascahyawiguna.showcase.common.util

import android.content.Context
import android.content.Intent
import io.github.bagascahyawiguna.showcase.domain.model.TvShow

object ShareUtils {

    fun shareTvShow(context: Context, show: TvShow) {
        val stringBuilder = StringBuilder()

        // 1. Show Title
        stringBuilder.append(show.name)

        // 2. Show Summary (Sanitized from HTML)
        val plainSummary = show.summary.stripHtml()
        if (plainSummary.isNotBlank()) {
            stringBuilder.append("\n\n").append(plainSummary)
        }

        // 3. Official TVMaze URL (API provided url or fallback)
        val tvMazeUrl = show.url ?: "https://www.tvmaze.com/shows/${show.id}"
        stringBuilder.append("\n\n").append(tvMazeUrl)

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, stringBuilder.toString())
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Share TV Show")
        context.startActivity(shareIntent)
    }
}
