//
//  Stub.swift
//  Stock_Tracker
//
//  Created by Luke Dutton on 4/13/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared_Stock_Tracker
import UIKit

extension ArticleWidgetModel {
    static var stubImageData: Data {
        UIImage(named: "placeholder")!.jpegData(compressionQuality: 0.7)!
    }
    
    static var stubArticleWithImageData: ArticleWidgetModel {
        .init(state: .article(article: ArticleKT.companion.previewData[0], imageData: ArticleWidgetModel.stubImageData))
    }
    
    static var stubs: [ArticleWidgetModel] {
        ArticleKT.companion.previewData.map { article -> ArticleWidgetModel in
                .init(state: .article(article: article, imageData: ArticleWidgetModel.stubImageData))
        }
    }
    
    static var placeholders: [ArticleWidgetModel] {
        (0..<5).map { (_) -> ArticleWidgetModel in
                .init(state: .placeholder)
        }
    }
}

extension ArticleEntry {
    static var placeholder: ArticleEntry {
        ArticleEntry(date: Date(), state: .articles(ArticleWidgetModel.placeholders), category: .entertainment)
    }
}
