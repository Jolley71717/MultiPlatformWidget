package com.example.forthewidgets.widget.models

enum class CategoryKt {
    GENERAL,
    BUSINESS,
    TECHNOLOGY,
    ENTERTAINMENT,
    SPORTS,
    SCIENCE,
    HEALTH;

    val text = this.name
    companion object {
        fun allCases() = values().asList()
        fun allACases() = values().asIterable()
    }
}
