package com.example.forthewidgets.widget.models

import com.benasher44.uuid.uuid4
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.Serializable
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
    //    var captionText: String {
//        "\(source.name) ‧ \(relativeDateFormatter.localizedString(for: publishedAt, relativeTo: Date()))"
//    }

    companion object {

//        @JvmField
        val client = HttpClient()

//        @JvmField
        val previewData: List<ArticleKT> = run {
            /* Will want to use this later to perform queries
            suspend fun getHtml(): String {
                val response = client.get("https://ktor.io/docs")
                return response.bodyAsText()
            }
            */
            getResources()
            this.javaClass.classLoader.getResource("app.properties").path
            this::class.get

            val fileContent = ArticleKT::class.java.getResource("/html/file.html").readText()


            return@run TODO()
        }
    }

}


// TODO add the expect class herey

expect class FileResource(location: String){
    val json: String?
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