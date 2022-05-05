//
//  ArticleWidgetModel.swift
//  Stock_Tracker
//
//  Created by Luke Dutton on 4/12/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared_Stock_Tracker

struct ArticleWidgetModel: Identifiable {
    
    enum State {
        case placeholder
        case article(article: ArticleKT, imageData: Data?)
    }
    
    let state: State
    var id: UUID {
        switch state {
            case .placeholder:
                return UUID()
            case .article(let article, _):
//            return UUID()
            return  UUID(uuidString: article.id!) ?? UUID()
        }
    }
    
    var title: String {
        switch state {
        case .placeholder:
            return "this is just placeholder text"
        case .article(let article, let _):
            return article.title
        }
    }
    
    var subtitle: String {
        switch state {
        case .placeholder:
            return "this is just placeholder text"
        case .article(let article, let _):
            return article.descriptionText
        }
    }
    
    
    var url: URL {
        switch state {
        case .placeholder:
            return URL(string: "Stock_Tracker://home")!
        case .article(let article, let _):
            return URL(string: article.url)!
        }
    }
    
    var isPlaceholder: Bool {
        if case .placeholder = state {
            return true
        }
        
        return false
    }
    
    var article: ArticleKT? {
        if case .article(let article, _) = state {
            return article
        }
    
        return nil
    }
    
    var imageData: Data? {
        if case .article(_, let imageData) = state {
            return imageData
        }
        return nil
    }
}
