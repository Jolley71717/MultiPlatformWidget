package com.example.forthewidgets.widget.models

import com.benasher44.uuid.UUID
import com.benasher44.uuid.Uuid
import com.benasher44.uuid.bytes
import com.benasher44.uuid.uuid4
//let activityTypeViewKey = "com.alfianlosari.xcanews.view"
//let activityURLKey = "xcanews.url.key"
//
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
}

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