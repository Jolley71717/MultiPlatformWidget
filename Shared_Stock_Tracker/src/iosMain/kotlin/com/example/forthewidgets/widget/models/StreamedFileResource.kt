package com.example.forthewidgets.widget.models

import com.example.forthewidgets.widget.MR


actual object StreamedFileResource {
    actual fun getJson(location: String): String = getText()

    fun getText(): String {
        val textStuff = MR.files.news.readText()
        return textStuff
    }
}