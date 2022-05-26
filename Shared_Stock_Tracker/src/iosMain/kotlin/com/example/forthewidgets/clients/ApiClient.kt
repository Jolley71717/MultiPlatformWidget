package com.example.forthewidgets.clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class ApiClient actual constructor(engine: HttpClientEngine?) {
    actual val httpClient: HttpClient = HttpClient(engine ?: Darwin.create())
}
