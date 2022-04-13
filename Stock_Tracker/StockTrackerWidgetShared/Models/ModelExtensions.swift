//
//  ModelExtensions.swift
//  Stock_Tracker
//
//  Used to help add some of the swift features to kotlin models
//  Created by Luke Dutton on 4/13/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared_Stock_Tracker

extension CategoryKt: Identifiable { }
extension NewsAPIResponseKt: Codable { }

extension ArticleKT {
    
    static var previewData: [ArticleKT] {
        let previewDataURL = Bundle.main.url(forResource: "news", withExtension: "json")!
        let data = try! Data(contentsOf: previewDataURL)
        
        let jsonDecoder = JSONDecoder()
        jsonDecoder.dateDecodingStrategy = .iso8601
        
        let apiResponse = try! jsonDecoder.decode(NewsAPIResponseKt.self, from: data)
        if let articles = apiResponse.articles {
            return articles
        } else {
            return []
        }
//        return apiResponse.articles ?? []
    }
    
    static var previewCategoryArticles: [CategoryArticlesKt]? {
        let articles = previewData
//        if let arrayCategories = CategoryKt.values() as [CategoryKt] {
//
//        }
//        return CategoryKt.allCases().map {
//            .init(categoryKt: $0, articles: articles.shuffled())
//        }
        return nil
    }
    
}
