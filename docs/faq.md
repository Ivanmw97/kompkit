# FAQ

## Why start with utilities instead of UI components?

Utilities provide immediate value across platforms without requiring design decisions or framework-specific implementations. They establish the foundation for cross-platform parity and can be used in any codebase. UI components will be considered in future phases once the utility layer is stable.

## Is it tree-shakable?

Yes. The web package is built with `tsup` and exports individual functions. Modern bundlers like Webpack, Vite, and Rollup will only include the utilities you import.

## Does it support multiple locales?

Yes. The `formatCurrency` utility accepts a `locale` parameter (e.g., `"en-US"`, `"es-ES"`, `"ja-JP"`). It uses the native `Intl.NumberFormat` API on web and `NumberFormat` on Android, both of which support all standard locales.

## Will there be wrappers for React/Vue later?

Possibly. The current utilities are framework-agnostic and work directly in React, Vue, or vanilla JS. If specific hooks or composables would add value (e.g., `useDebounce`), they may be added as optional packages in the future.

## Is it production-ready?

Not yet. The library is in `0.0.x-alpha` status. APIs may change, and the test coverage is still expanding. Use it in experimental projects, but avoid production deployments until a stable `1.0.0` release.
