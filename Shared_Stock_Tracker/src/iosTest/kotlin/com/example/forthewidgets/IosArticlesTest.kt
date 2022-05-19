package com.example.forthewidgets

import com.example.forthewidgets.widget.models.ArticleKT
import com.example.forthewidgets.widget.models.ArticleResponse
import com.example.forthewidgets.widget.models.StreamedFileResource
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IosArticlesTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
        fun testJsonRead() {
            val articleListJson = StreamedFileResource.getJson("fake")
            assertTrue(articleListJson.isNotBlank())
            val decodedArticles = json.decodeFromString<ArticleResponse>(articleListJson)
            assertTrue(decodedArticles.articles.isNotEmpty())
        }
}