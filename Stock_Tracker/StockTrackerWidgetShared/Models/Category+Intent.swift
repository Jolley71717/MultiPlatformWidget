//
//  Category+Intent.swift
//  Stock_Tracker
//
//  Created by Luke Dutton on 4/13/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared_Stock_Tracker

extension CategoryKt {
//    convenience init(_ categoryIntentParam: CategoryIntentParam) {
//        switch categoryIntentParam {
//        case .unknown: self = CategoryKt.general
//        }
//    }
    
    static func convertCatIntentParam(categoryIntentParam: CategoryIntentParam) -> CategoryKt {
        var switchedVal: CategoryKt
        switch categoryIntentParam {
            case .unknown: switchedVal = CategoryKt.general
            case .general: switchedVal = CategoryKt.general
            case .business: switchedVal = CategoryKt.business
            case .technology: switchedVal = CategoryKt.technology
            case .entertainment: switchedVal = CategoryKt.entertainment
            case .sports: switchedVal = CategoryKt.sports
            case .science: switchedVal = CategoryKt.science
            case .health: switchedVal = CategoryKt.health
        }
        return switchedVal
    }
}

//Also look at doing this
/**
 enum ProtocolState {
     case waiting, talking
     
     func signal() -> ProtocolState {
         switch self {
         case .waiting:
             return .talking
         case .talking:
             return .waiting
         }
     }
 }
 */

