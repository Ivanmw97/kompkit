# Getting Started with KompKit

KompKit is a comprehensive component library that provides UI components for multiple frameworks including Vue, React, and Android. This guide will help you get started with using KompKit in your projects.

## Installation

KompKit is organized as a monorepo with separate packages for each framework. You can install the specific package you need for your project.

### Vue Components

```bash
npm install @kompkit/vue
# or
yarn add @kompkit/vue
```

### React Components

```bash
npm install @kompkit/react
# or
yarn add @kompkit/react
```

### Android Components

For Android, add the dependency to your app's build.gradle file:

```gradle
implementation 'com.kompkit:android:0.1.0'
```

## Usage Examples

### Vue Button Component

```vue
<template>
  <div>
    <KButton variant="primary">Primary Button</KButton>
    <KButton variant="secondary">Secondary Button</KButton>
    <KButton variant="outline">Outline Button</KButton>
    <KButton variant="text">Text Button</KButton>
  </div>
</template>

<script setup>
import { KButton } from '@kompkit/vue';
</script>
```

### React Button Component

```jsx
import React from 'react';
import { Button } from '@kompkit/react';

function App() {
  return (
    <div>
      <Button variant="primary">Primary Button</Button>
      <Button variant="secondary">Secondary Button</Button>
      <Button variant="outline">Outline Button</Button>
      <Button variant="text">Text Button</Button>
    </div>
  );
}
```

### Android Button Component

```kotlin
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kompkit.android.button.KompButton
import com.kompkit.android.button.KompButtonVariant

@Composable
fun ButtonsExample() {
    KompButton(
        text = "Primary Button",
        onClick = { /* handle click */ },
        variant = KompButtonVariant.PRIMARY
    )
    
    KompButton(
        text = "Secondary Button",
        onClick = { /* handle click */ },
        variant = KompButtonVariant.SECONDARY
    )
    
    KompButton(
        text = "Outline Button",
        onClick = { /* handle click */ },
        variant = KompButtonVariant.OUTLINE
    )
    
    KompButton(
        text = "Text Button",
        onClick = { /* handle click */ },
        variant = KompButtonVariant.TEXT
    )
}
```

## Customization

Each component can be customized through props/parameters. Refer to the specific component documentation for details on available customization options.

## Contributing

Contributions are welcome! Please see our contributing guidelines for more information.

## License

KompKit is licensed under the MIT License.