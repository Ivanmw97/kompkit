# KompKit

[![Web CI](https://github.com/Kompkit/KompKit/actions/workflows/web.yml/badge.svg?branch=develop)](https://github.com/Kompkit/KompKit/actions/workflows/web.yml)
[![Android CI](https://github.com/Kompkit/KompKit/actions/workflows/android.yml/badge.svg?branch=develop)](https://github.com/Kompkit/KompKit/actions/workflows/android.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?logo=typescript&logoColor=white)](https://www.typescriptlang.org/)
[![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?logo=kotlin&logoColor=white)](https://kotlinlang.org/)

A lightweight cross-platform utility kit for Android (Kotlin) and Web (TypeScript): debounce, isEmail, formatCurrency.

## Overview

KompKit provides essential utility functions that work seamlessly across web (TypeScript) and Android (Kotlin) platforms. Built with developer experience in mind, it offers identical APIs across platforms while leveraging platform-specific optimizations.

### Core Utilities

- **🕐 debounce** - Delay function execution until after a wait period (prevents excessive API calls)
- **📧 isEmail** - Validate email addresses with robust regex patterns
- **💰 formatCurrency** - Format numbers as currency with full locale support

### Key Features

- ✅ **Cross-platform compatibility** - Identical APIs for web and Android
- ✅ **TypeScript support** - Full type safety and IntelliSense
- ✅ **Zero dependencies** - Lightweight with no external dependencies
- ✅ **Comprehensive testing** - 100% test coverage
- ✅ **Modern tooling** - Built with latest TypeScript and Kotlin standards
- ✅ **Rich documentation** - Auto-generated API docs with examples

## Installation

### Web (React/Vue)

```bash
npm install @kompkit/core
```

### Android

Add to your `build.gradle.kts` (Module: app):

```kotlin
dependencies {
    implementation(files("path/to/kompkit/packages/core/android"))
    // Required for debounce functionality
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}
```

**Alternative:** Clone the repository and include the Android module directly:

```bash
git clone https://github.com/Kompkit/KompKit.git
# Add the module to your Android project
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

### Prerequisites

- **Node.js** 18+ and npm
- **Java** 17+ (for Android development)
- **Kotlin** 1.9+ (automatically managed by Gradle)

### Setup

```bash
# Clone the repository
git clone https://github.com/Kompkit/KompKit.git
cd kompkit

# Install dependencies
npm install

# Build all packages
npm run build

# Run tests for both platforms
npm run test

# Run tests individually
npm run test:web      # Web/TypeScript tests
npm run test:android  # Android/Kotlin tests
```

### Documentation

Generate documentation for both platforms:

```bash
# Generate all documentation
npm run docs:all

# Generate web docs only (TypeDoc)
npm run docs:web

# Generate Android docs only (Dokka)
npm run docs:android

# Serve documentation locally
cd docs && python3 -m http.server 8080
# Visit http://localhost:8080
```

### Project Commands

| Command | Description |
|---------|-------------|
| `npm run build` | Build all packages |
| `npm run test` | Run all tests |
| `npm run test:web` | Run web tests only |
| `npm run test:android` | Run Android tests only |
| `npm run docs:all` | Generate all documentation |
| `npm run docs:web` | Generate web documentation |
| `npm run docs:android` | Generate Android documentation |

## Project Structure

```
kompkit/
├── packages/
│   └── core/
│       ├── web/                 # TypeScript/JavaScript package
│       │   ├── src/            # Source files
│       │   │   ├── debounce.ts
│       │   │   ├── validate.ts
│       │   │   ├── format.ts
│       │   │   └── index.ts
│       │   ├── tests/          # Test files
│       │   ├── dist/           # Built output
│       │   └── package.json
│       └── android/            # Kotlin/Android package
│           ├── src/
│           │   ├── main/kotlin/com/kompkit/core/
│           │   │   ├── Debounce.kt
│           │   │   ├── Validate.kt
│           │   │   └── Format.kt
│           │   └── test/       # Test files
│           └── build.gradle.kts
├── docs/                       # Documentation
│   ├── api/
│   │   ├── web/               # TypeDoc generated docs
│   │   └── android/           # Dokka generated docs
│   ├── getting-started.md
│   └── [other guides]
├── LICENSE                     # MIT License
├── README.md                   # This file
├── package.json               # Root package configuration
└── lerna.json                 # Lerna configuration
```

## API Reference

### debounce

**Web:** `debounce<T>(fn: T, wait?: number): T`  
**Android:** `debounce<T>(waitMs: Long, scope: CoroutineScope, dest: (T) -> Unit): (T) -> Unit`

Delays function execution until after wait period has elapsed since the last time it was invoked.

### isEmail

**Web:** `isEmail(v: string): boolean`  
**Android:** `isEmail(value: String): Boolean`

Validates whether a string matches a basic email pattern.

### formatCurrency

**Web:** `formatCurrency(amount: number, currency?: string, locale?: string): string`  
**Android:** `formatCurrency(amount: Double, currency: String, locale: Locale): String`

Formats a number as a localized currency string.

## Roadmap

- [ ] Add more utility functions (throttle, deepClone, etc.)
- [ ] Support for React Native
- [ ] iOS Swift implementation
- [ ] Performance benchmarks
- [ ] CI/CD pipeline setup

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

- 📖 [Documentation](docs/)
- 🐛 [Issue Tracker](https://github.com/Kompkit/KompKit/issues)
- 💬 [Discussions](https://github.com/Kompkit/KompKit/discussions)
