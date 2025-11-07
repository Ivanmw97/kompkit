/**
 * Debounces a function call by delaying its execution until after a specified wait period.
 * Subsequent calls within the wait period reset the timer.
 * 
 * @param fn - The function to debounce.
 * @param wait - Milliseconds to wait before invoking the function. Defaults to 250ms.
 * @returns A debounced version of the function.
 * 
 * @example
 * ```ts
 * const search = debounce((query: string) => {
 *   console.log('Searching:', query);
 * }, 300);
 * 
 * search('hello'); // Will execute after 300ms if no other calls are made
 * ```
 */
export function debounce<T extends (...args: any[]) => any>(fn: T, wait = 250) {
  let t: ReturnType<typeof setTimeout> | null = null;
  return (...args: Parameters<T>) => {
    if (t) clearTimeout(t);
    t = setTimeout(() => fn(...args), wait);
  };
}
