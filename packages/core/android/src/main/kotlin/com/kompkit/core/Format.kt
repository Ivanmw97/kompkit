package com.kompkit.core

import java.text.NumberFormat
import java.util.*

/**
 * Formats a number as a localized currency string.
 *
 * @param amount The numeric amount to format.
 * @param currency The currency code (e.g., "USD", "EUR", "JPY"). Defaults to "EUR".
 * @param locale The locale for formatting. Defaults to Spanish (Spain).
 * @return A formatted currency string.
 *
 * @sample
 * ```kotlin
 * formatCurrency(1234.56) // "1.234,56 €" (es-ES default)
 * formatCurrency(1234.56, "USD", Locale.US) // "$1,234.56"
 * formatCurrency(1000.0, "JPY", Locale.JAPAN) // "¥1,000"
 * ```
 */
fun formatCurrency(amount: Double, currency: String = "EUR", locale: Locale = Locale("es", "ES")): String {
    val nf = NumberFormat.getCurrencyInstance(locale)
    nf.currency = Currency.getInstance(currency)
    return nf.format(amount)
}
