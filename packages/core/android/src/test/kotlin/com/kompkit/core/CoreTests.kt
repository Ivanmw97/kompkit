package com.kompkit.core

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class CoreTests {

    @Test
    fun testIsEmail() {
        assertTrue(isEmail("test@example.com"))
        assertFalse(isEmail("invalid"))
    }

    @Test
    fun testFormatCurrency() {
        val formatted = formatCurrency(1234.56)
        assertTrue(formatted.contains("€"))
    }

    @Test
    fun testDebounce() = runBlocking {
        var called = false
        val debounced = debounce<String>(200, this) { called = true }
        debounced("a")
        delay(100)
        assertFalse(called)
        delay(200)
        assertTrue(called)
    }
}
