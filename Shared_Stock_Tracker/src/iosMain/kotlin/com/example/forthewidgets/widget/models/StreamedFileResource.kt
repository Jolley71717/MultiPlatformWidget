package com.example.forthewidgets.widget.models

import com.example.forthewidgets.widget.MR


actual object StreamedFileResource {
    actual fun getJson(location: String): String = MR.files.news.readText()
}