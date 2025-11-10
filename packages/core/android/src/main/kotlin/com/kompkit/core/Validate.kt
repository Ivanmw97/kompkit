package com.kompkit.core

/**
 * KompKit Core - Android validation utilities
 */
private val EMAIL_RE = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")

/**
 * Validates whether a string matches a basic email pattern.
 *
 * @param value The string to validate.
 * @return `true` if the string is a valid email format, `false` otherwise.
 *
 * @sample
 * ```kotlin
 * isEmail("user@example.com") // true
 * isEmail("invalid@") // false
 * isEmail("  test@domain.org  ") // true (whitespace is trimmed)
 * ```
 */
fun isEmail(value: String): Boolean = EMAIL_RE.matches(value.trim())
