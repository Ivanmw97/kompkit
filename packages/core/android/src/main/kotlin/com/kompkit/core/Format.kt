package com.kompkit.core

import java.text.NumberFormat
import java.util.*

fun formatCurrency(amount: Double, currency: String = "EUR", locale: Locale = Locale("es", "ES")): String {
    val nf = NumberFormat.getCurrencyInstance(locale)
    nf.currency = Currency.getInstance(currency)
    return nf.format(amount)
}
