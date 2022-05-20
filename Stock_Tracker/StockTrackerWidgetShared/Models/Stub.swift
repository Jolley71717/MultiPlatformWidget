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
}
