package io.github.bagascahyawiguna.showcase.common.util

import androidx.core.text.HtmlCompat

fun String?.stripHtml(): String {
    if (this.isNullOrBlank()) return ""
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString().trim()
}
