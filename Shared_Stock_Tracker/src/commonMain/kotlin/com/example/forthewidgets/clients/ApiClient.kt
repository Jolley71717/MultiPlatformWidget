package com.example.forthewidgets.clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

expect class ApiClient(engine: HttpClientEngine? = null) {
    val httpClient: HttpClient
}
