package com.example.forthewidgets.widget.models

import com.benasher44.uuid.uuid4
import io.ktor.client.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.jvm.JvmField

//let activityTypeViewKey = "com.alfianlosari.xcanews.view"
//let activityURLKey = "xcanews.url.key"
//
@Serializable
data class ArticleKT(
    val id: String? = uuid4().toString(),
    val source: Source,
    val title: String,
    val url: String,
    val publishedAt: String,
    val author: String?,
    val description: String?,
    val urlToImage: String,
){
    // Todo these are carry-overs from swift not doing defaults well i guess
    val authorText = author ?: ""
    val descriptionText = description ?: ""
    fun getCaptionText(): String = "${source.name} ‧ $publishedAt" // todo look at creating specific ones for ios


//    static var previewCategoryArticles: [CategoryArticlesKt]? {
//        let articles = companion.previewData
//                return CategoryKt.companion.allCases().map {
//                    .init(categoryKt: $0, articles: articles.shuffled())
//                }
//    }

    companion object {
        private val jsonDecoder = Json { ignoreUnknownKeys = true }
        val client = HttpClient()
        @JvmField
        val previewData: List<ArticleKT> = run {
            /* Will want to use this later to perform queries
            suspend fun getHtml(): String {
                val response = client.get("https://ktor.io/docs")
                return response.bodyAsText()
            }
            */

            return@run StreamedFileResource.NEWS_JSON
                .let(this::jsonToArticleResponse)
                .articles
        }
        @JvmField
        val previewCategoryArticles: List<CategoryArticlesKt> = CategoryKt.values()
            .map { CategoryArticlesKt(categoryKt = it, articles = previewData.shuffled() ) }

        private fun jsonToArticleResponse(json: String) = jsonDecoder.decodeFromString<ArticleResponse>(json)
    }
}

@Serializable
data class Source(val name: String)



// TODO would be interesting to add this functionality
//extension Article {
//
//    static var previewData: [Article] {
//        let previewDataURL = Bundle.main.url(forResource: "news", withExtension: "json")!
//        let data = try! Data(contentsOf: previewDataURL)
//
//        let jsonDecoder = JSONDecoder()
//        jsonDecoder.dateDecodingStrategy = .iso8601
//
//                let apiResponse = try! jsonDecoder.decode(NewsAPIResponse.self, from: data)
//            return apiResponse.articles ?? []
//        }
//
//    static var previewCategoryArticles: [CategoryArticles] {
//        let articles = previewData
//                return Category.allCases.map {
//                    .init(category: $0, articles: articles.shuffled())
//                }
//    }
//
//}