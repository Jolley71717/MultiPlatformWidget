import SwiftUI
import Shared_Stock_Tracker

struct ContentView: View {

    let greet = Greeting().greeting()
    let newsApi: NewsAPIKt
    @State private var newsInfo: String = "Loading"
    
    // Here's your initializer
    init() {
        self.newsApi = NewsAPIKt()
    }
    
	var body: some View {
		Text(greet)
        Text(newsInfo)
            .task {
                newsApi.search(query: "kotlin") { result, error in
                    if let result = result {
                        self.newsInfo = String(result.count)
                    } else if let error = error {
                        newsInfo = "Error: \(error)"
                    }
                }
        }
	}

    enum LoadError: Error {
        case fetchFailed, decodeFailed
    }
}



struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
