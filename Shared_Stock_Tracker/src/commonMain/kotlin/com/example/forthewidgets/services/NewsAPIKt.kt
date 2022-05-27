package com.example.forthewidgets.services

import com.example.forthewidgets.clients.ApiClient
import com.example.forthewidgets.widget.models.ArticleKT
import com.example.forthewidgets.widget.models.ArticleResponse
import com.example.forthewidgets.widget.models.CategoryKt
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.logging.KtorSimpleLogger
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class NewsAPIKt constructor(apiClient: ApiClient) {
    constructor() : this(ApiClient())

    private val logger = KtorSimpleLogger("NewsApi")
    private val httpClient = apiClient.httpClient
    private val jsonMapper = Json { ignoreUnknownKeys = true }
    private val apiKey = ApiKeyConfig.apiKey() // todo figure out how to configure this external to code

    suspend fun search(query: String): List<ArticleKT> {
        return coroutineScope { fetchArticles(generateSearchUrl(query)) }
    }

    suspend fun fetch(category: CategoryKt): List<ArticleKT> {
        return coroutineScope { fetchArticles(generateNewsURL(category)) }
    }

    private val fakeclient = HttpClient()
    suspend fun getHtml(): String {
        return coroutineScope {
            val response = fakeclient.get("https://ktor.io/docs")
            response.bodyAsText()
        }
    }

    private suspend fun fetchArticles(url: String): List<ArticleKT> {
        val response = httpClient.get(url)
        val jsonBody = response.bodyAsText()
        val articles = if (response.status.value.betweenI(200..299, 400..499) &&
            response.status == HttpStatusCode.OK
        ) {
            jsonBody
        } else {
            logger.warn("An unsuccessful news response was received. Status: ${response.status.value}. Response: $jsonBody ")
            null
        }?.let { responseBody ->
            jsonMapper.decodeFromString<ArticleResponse>(responseBody).articles
        } ?: emptyList()
        return articles
    }

    private suspend fun generateSearchUrl(query: String): String {
        println("Attempting to make a url")
        return "https://newsapi.org/v2/everything?" +
            "apiKey=$apiKey" +
            "&language=en" +
            "&q=$query"
    }

    private suspend fun generateNewsURL(category: CategoryKt): String {
        return "https://newsapi.org/v2/top-headlines?" +
            "apiKey=$apiKey" +
            "&language=en" +
            "&category=${category.text}"
    }

    /**
     * Between -> Inclusive
     */
    private fun Int.betweenI(vararg ranges: IntRange) = ranges.any { range -> this in range }
}
