//
//  ArticleEntry.swift
//  Stock_Tracker
//
//  Created by Luke Dutton on 4/13/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import WidgetKit
import Shared_Stock_Tracker

struct ArticleEntry: TimelineEntry {
    enum State {
        case articles([ArticleWidgetModel])
        case failure(Error)
    }
    
    let date: Date
    let state: State
    let category: CategoryKt
}
