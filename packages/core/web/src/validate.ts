const EMAIL_RE = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

/**
 * Validates whether a string matches a basic email pattern.
 * 
 * @param v - The string to validate.
 * @returns `true` if the string is a valid email format, `false` otherwise.
 * 
 * @example
 * ```ts
 * isEmail('user@example.com'); // true
 * isEmail('invalid@'); // false
 * isEmail('  test@domain.org  '); // true (whitespace is trimmed)
 * ```
 */
export function isEmail(v: string): boolean {
  return EMAIL_RE.test(v.trim());
}
