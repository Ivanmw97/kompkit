export function formatCurrency(
  amount: number,
  currency = "EUR",
  locale = "es-ES"
): string {
  return new Intl.NumberFormat(locale, { style: "currency", currency }).format(amount);
}
