package com.example.forthewidgets.services

import com.example.forthewidgets.clients.ApiClient
import com.example.forthewidgets.widget.models.ArticleKT
import com.example.forthewidgets.widget.models.ArticleResponse
import com.example.forthewidgets.widget.models.CategoryKt
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.logging.KtorSimpleLogger
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class NewsAPI constructor(apiClient: ApiClient) {
    constructor() : this(ApiClient())

    private val logger = KtorSimpleLogger("NewsApi")
    private val httpClient = apiClient.httpClient
    private val jsonMapper = Json { ignoreUnknownKeys = true }
    private val apiKey = ApiKeyConfig.apiKey() // todo figure out how to configure this external to code

    suspend fun search(query: String): List<ArticleKT> {
        return fetchArticles(generateSearchUrl(query))
    }

    suspend fun fetch(category: CategoryKt): List<ArticleKT> {
        return fetchArticles(generateNewsURL(category))
    }

    private val fakeclient = HttpClient()
    suspend fun getHtml(): String {
        val response = fakeclient.get("https://ktor.io/docs")
        return response.bodyAsText()
    }

    private suspend fun fetchArticles(url: String): List<ArticleKT> {
        println("Getting ready to pull the url: $url")
        val response = httpClient.get(url)
        println("got a resposne with status: ${response.status.value}")
        val jsonBody = response.bodyAsText()
        val articles = if (response.status.value.betweenI(200..299, 400..499) &&
            response.status == HttpStatusCode.OK
        ) {
            jsonBody
        } else {
            logger.warn("An unsuccessful news response was received. Status: ${response.status.value}. Response: $jsonBody ")
            null
        }?.let { responseBody ->
            jsonMapper.decodeFromString<ArticleResponse>(responseBody).articles
        } ?: emptyList()
        return articles
    }

    private suspend fun generateSearchUrl(query: String): String {
        println("Attempting to make a url")
        return "https://newsapi.org/v2/everything?" +
            "apiKey=$apiKey" +
            "&language=en" +
            "&q=$query"
    }

    private suspend fun generateNewsURL(category: CategoryKt): String {
        return "https://newsapi.org/v2/top-headlines?" +
            "apiKey=$apiKey" +
            "&language=en" +
            "&category=${category.text}"
    }

    /**
     * Between -> Inclusive
     */
    private fun Int.betweenI(vararg ranges: IntRange) = ranges.any { range -> this in range }
}

// /////// SWIFT
/*
//
//  NewsAPI.swift
//  XCANews
//
//  Created by Alfian Losari on 6/27/21.
//

import Foundation

struct NewsAPI {

    static let shared = NewsAPI()
    private init() {}

    private let apiKey = "newsapi.org"
    private let session = URLSession.shared
    private let jsonDecoder: JSONDecoder = {
        let decoder = JSONDecoder()
        decoder.dateDecodingStrategy = .iso8601
        return decoder
    }()

    func fetch(from category: Category) async throws -> [Article] {
        try await fetchArticles(from: generateNewsURL(from: category))
    }

    func search(for query: String) async throws -> [Article] {
        try await fetchArticles(from: generateSearchURL(from: query))
    }

    private func fetchArticles(from url: URL) async throws -> [Article] {
        let (data, response) = try await session.data(from: url)

        guard let response = response as? HTTPURLResponse else {
            throw generateError(description: "Bad Response")
        }

        switch response.statusCode {

        case (200...299), (400...499):
            let apiResponse = try jsonDecoder.decode(NewsAPIResponse.self, from: data)
            if apiResponse.status == "ok" {
                return apiResponse.articles ?? []
            } else {
                throw generateError(description: apiResponse.message ?? "An error occured")
            }
        default:
            throw generateError(description: "A server error occured")
        }
    }

    private func generateError(code: Int = 1, description: String) -> Error {
        NSError(domain: "NewsAPI", code: code, userInfo: [NSLocalizedDescriptionKey: description])
    }

    private func generateSearchURL(from query: String) -> URL {
        let percentEncodedString = query.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed) ?? query
        var url = "https://newsapi.org/v2/everything?"
        url += "apiKey=\(apiKey)"
        url += "&language=en"
        url += "&q=\(percentEncodedString)"
        return URL(string: url)!
    }

    private func generateNewsURL(from category: Category) -> URL {
        var url = "https://newsapi.org/v2/top-headlines?"
        url += "apiKey=\(apiKey)"
        url += "&language=en"
        url += "&category=\(category.rawValue)"
        return URL(string: url)!
    }
}
 */
