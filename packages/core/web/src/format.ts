/**
 * Formats a number as a localized currency string.
 * 
 * @param amount - The numeric amount to format.
 * @param currency - The currency code (e.g., "USD", "EUR", "JPY"). Defaults to "EUR".
 * @param locale - The locale string (e.g., "en-US", "es-ES"). Defaults to "es-ES".
 * @returns A formatted currency string.
 * 
 * @example
 * ```ts
 * formatCurrency(1234.56); // "1.234,56 €" (es-ES default)
 * formatCurrency(1234.56, "USD", "en-US"); // "$1,234.56"
 * formatCurrency(1000, "JPY", "ja-JP"); // "¥1,000"
 * ```
 */
export function formatCurrency(
  amount: number,
  currency = "EUR",
  locale = "es-ES"
): string {
  return new Intl.NumberFormat(locale, { style: "currency", currency }).format(amount);
}
