package com.example.forthewidgets.widget.models

import com.example.forthewidgets.widget.MR

actual object StreamedFileResource {
    actual val NEWS_JSON = MR.files.news.readText()
    actual val KOTLIN_JSON = MR.files.kotlinNews.readText()
}
