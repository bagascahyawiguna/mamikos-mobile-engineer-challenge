package io.github.bagascahyawiguna.showcase.common.util

import android.content.Context
import android.content.Intent
import io.github.bagascahyawiguna.showcase.domain.model.TvShow
import java.util.Locale

object ShareUtils {

    fun shareTvShow(context: Context, show: TvShow) {
        val stringBuilder = StringBuilder()

        stringBuilder.append(show.name)

        show.ratingAverage?.let { rating ->
            val formattedRating = String.format(Locale.US, "%.1f", rating)
            stringBuilder.append("\n\n⭐ Rating: $formattedRating")
        }

        show.premiered?.let { premiered ->
            if (premiered.isNotBlank()) {
                stringBuilder.append("\n\n📅 Premiered: $premiered")
            }
        }

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, stringBuilder.toString())
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Share TV Show")
        context.startActivity(shareIntent)
    }
}
