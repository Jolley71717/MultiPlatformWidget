package com.example.forthewidgets

import kotlin.test.Test
import kotlin.test.assertTrue

class IosPlatformTest {
        @Test
        fun testHello() {
            assertTrue("iOS" in Platform().platform)
        }
}