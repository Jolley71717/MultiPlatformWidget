package com.example.forthewidgets

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}