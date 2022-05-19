package com.example.forthewidgets.widget.models

expect object StreamedFileResource{
    fun getJson(location: String): String
}