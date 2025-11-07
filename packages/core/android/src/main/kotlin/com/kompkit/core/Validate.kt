package com.kompkit.core

private val EMAIL_RE = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")

fun isEmail(value: String): Boolean = EMAIL_RE.matches(value.trim())
