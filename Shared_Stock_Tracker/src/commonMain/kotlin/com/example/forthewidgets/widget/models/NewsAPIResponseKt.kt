package com.example.forthewidgets.widget.models

import kotlinx.serialization.Serializable

@Serializable
data class NewsAPIResponseKt(
    val status: String,
    val totalResults: Int?,
    val articles: List<ArticleKT>,
    val code: String?,
    val message: String?
)
/*
struct NewsAPIResponse: Decodable {

    let status: String
            let totalResults: Int?
    let articles: [Article]?

    let code: String?
    let message: String?

}
*/