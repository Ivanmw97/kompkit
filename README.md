# KompKit

A lightweight cross-platform utility kit for Android, React and Vue.

## Overview

KompKit provides essential utility functions that work seamlessly across web (TypeScript) and Android (Kotlin) platforms. The library includes three core utilities:

- **debounce** - Delay function execution until after a wait period
- **isEmail** - Validate email addresses with regex
- **formatCurrency** - Format numbers as currency with locale support

## Installation

### Web (React/Vue)

```bash
npm install @kompkit/core
```

### Android

Add to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation(files("path/to/kompkit/packages/core/android"))
}
```

## Usage

### Web (TypeScript)

```typescript
import { debounce, isEmail, formatCurrency } from '@kompkit/core';

// Debounce a search function
const handleSearch = debounce((query: string) => {
  console.log('Searching for:', query);
}, 300);

// Validate email
const valid = isEmail('user@example.com'); // true

// Format currency
const price = formatCurrency(1234.56); // "1.234,56 €"
const priceUSD = formatCurrency(1234.56, 'USD', 'en-US'); // "$1,234.56"
```

### Android (Kotlin)

```kotlin
import com.kompkit.core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

// Debounce a search function
val scope = CoroutineScope(Dispatchers.Main)
val handleSearch = debounce<String>(300L, scope) { query ->
    println("Searching for: $query")
}

// Validate email
val valid = isEmail("user@example.com") // true

// Format currency
val price = formatCurrency(1234.56) // "1.234,56 €"
val priceUSD = formatCurrency(1234.56, "USD", Locale.US) // "$1,234.56"
```

## Development

This is a monorepo managed with Lerna and npm workspaces.

```bash
# Install dependencies
npm install

# Build all packages
npm run build

# Run tests
npm run test
```

## Structure

```
packages/
├── core/
│   ├── web/          # TypeScript utilities
│   └── android/      # Kotlin utilities
```

## License

MIT
