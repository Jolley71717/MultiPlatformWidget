package com.example.forthewidgets.widget.models

import com.example.forthewidgets.utils.MainActivity
import com.example.forthewidgets.widget.MR

actual object StreamedFileResource {
    actual fun getJson(location: String): String = MR.files.news.readText(context = MainActivity.instance)
}