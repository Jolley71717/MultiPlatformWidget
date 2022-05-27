//
//  ArticleProvider.swift
//  Stock_Tracker
//
//  Created by Luke Dutton on 5/20/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import WidgetKit
import Shared_Stock_Tracker


//struct ArticleProvider: IntentTimelineProvider {
//
//    typealias Entry = ArticleEntry
//    typealias Intent = SelectCategoryIntent
//
//    private let newsAPI = NewsApi.shared
//    private let urlSession = URLSession.shared
//
//    private func fetchImageData(from article: ArticleKT) async -> ArticleWidgetModel {
//        guard let url = article.urlToImage,
//              let (data, response) = try? await urlSession.data(from: url),
//              let httpResponse = response as? HTTPURLResponse, httpResponse.statusCode == 200
//        else {
//            return .init(state: .article(article: article, imageData: nil))
//        }
//        return .init(state: .article(article: article, imageData: data))
//    }
//}
