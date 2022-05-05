package com.example.forthewidgets.widget.models


enum class CategoryKt{
    GENERAL,
    BUSINESS,
    TECHNOLOGY,
    ENTERTAINMENT,
    SPORTS,
    SCIENCE,
    HEALTH;

    val text = this.name
    fun allCases() = CategoryKt.values().asList()
    fun allACases() = CategoryKt.values().asIterable()
}

