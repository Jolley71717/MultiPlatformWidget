package com.example.forthewidgets.widget.models

import com.example.forthewidgets.widget.MR


actual class StreamedFileResource actual constructor(location: String) {
    actual val json: String?
        get() = MR.files.news.readText()
}