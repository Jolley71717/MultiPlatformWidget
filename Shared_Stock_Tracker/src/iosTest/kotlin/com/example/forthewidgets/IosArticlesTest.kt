package com.example.forthewidgets

import kotlin.test.Test
import kotlin.test.assertTrue

class IosArticlesTest {
        @Test
        fun testHello() {
            val whatItIs = Platform().platform
            assertTrue("iOS" in Platform().platform)
        }
}