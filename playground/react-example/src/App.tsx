import React from 'react'
import { Button } from '@kompkit/react'

export default function App() {
  return (
    <div style={{ padding: '2rem' }}>
      <h1>KompKit React Playground</h1>
      <Button>Default</Button>
      <Button variant="primary">Primary</Button>
      <Button variant="secondary">Secondary</Button>
    </div>
  )
}
