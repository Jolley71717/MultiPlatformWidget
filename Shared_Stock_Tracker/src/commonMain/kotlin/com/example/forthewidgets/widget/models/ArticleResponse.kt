package com.example.forthewidgets.widget.models

import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val status: String,
    val totalResults: Long,
    val articles: List<ArticleKT>
)