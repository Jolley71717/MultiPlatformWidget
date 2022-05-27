package com.example.forthewidgets.clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO

actual class ApiClient actual constructor(engine: HttpClientEngine?) {
    actual val httpClient: HttpClient = HttpClient(engine ?: CIO.create())
}