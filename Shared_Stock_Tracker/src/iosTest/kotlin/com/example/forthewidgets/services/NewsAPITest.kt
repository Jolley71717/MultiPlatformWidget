package com.example.forthewidgets.services

import com.example.forthewidgets.clients.ApiClient
import com.example.forthewidgets.widget.models.StreamedFileResource
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.runBlocking
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

internal class NewsAPITest {

    @Test
    fun `search all the things`() {
        runBlocking {
            val articles = newsAPI.search(ALL_ARTICLES)
            assertTrue(articles.isNotEmpty())
        }
    }

    @Test
    fun `search but no results`() {
        runBlocking {
            val articles = newsAPI.search(NO_RESULTS)
            assertTrue(articles.isEmpty(), "Expected no results but found ${articles.size}")
        }
    }

    @Ignore
    @Test
    /**
     * This test can be run locally if you have access ta the api key
     */
    fun `search usingRealInfo`() {
        println("something is starting 1111111111")
        val newssssssApi = NewsAPI()
        println("Api Created 1111111111")
        runBlocking {
            println("something is running in coroutine 1111111111")
            val articles = newssssssApi.search(REAL_KOTLIN_RESULTS)
            println("waiting to start 11111111")
            assertTrue(articles.isNotEmpty(), "Expected no results but found ${articles.size}")
        }
    }

    @Ignore
    @Test
    /**
     * This test can be run locally if you have access ta the api key
     */
    fun `search using ktor`() {
        println("something is starting 1111111111")
        val newssssssApi = NewsAPI()
        println("Api Created 1111111111")
        runBlocking {
            println("something is running in coroutine 1111111111")
            val html = newssssssApi.getHtml()
            println("waiting to start 11111111")
            assertTrue(html.isNotBlank(), "Expected no results but found ${html.length}")
        }
    }

    @Ignore
    @Test
    fun fetch() {
    }

    private val mockEngine = MockEngine { request ->
        val requestUrl = request.url.fullPath
        when {
            requestUrl.contains(ALL_ARTICLES) -> respond(
                content = ByteReadChannel(StreamedFileResource.NEWS_JSON),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
            requestUrl.contains(NO_RESULTS) -> {
                respond(
                    content = ByteReadChannel("""{"status": "ok","totalResults":0,"articles": []}"""),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
            else ->
                respond(
                    content = ByteReadChannel("""{}"""),
                    status = HttpStatusCode.BadRequest,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
        }
    }

    private val newsAPI = NewsAPI(ApiClient(mockEngine))

    companion object {
        private const val ALL_ARTICLES = "all_articles"
        private const val NO_RESULTS = "no_results"
        private const val REAL_KOTLIN_RESULTS = "kotlin"
    }
}
