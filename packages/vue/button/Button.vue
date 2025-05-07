<template>
  <button
    :class="['kompkit-button', `kompkit-button--${variant}`, `kompkit-button--${size}`]"
    :disabled="disabled"
    @click="$emit('click', $event)"
  >
    <slot></slot>
  </button>
</template>

<script setup lang="ts">
defineProps({
  variant: {
    type: String,
    default: 'primary',
    validator: (value: string) => ['primary', 'secondary', 'outline', 'text'].includes(value)
  },
  size: {
    type: String,
    default: 'medium',
    validator: (value: string) => ['small', 'medium', 'large'].includes(value)
  },
  disabled: {
    type: Boolean,
    default: false
  }
});

defineEmits(['click']);
</script>

<style scoped>
.kompkit-button {
  font-family: sans-serif;
  border-radius: 4px;
  font-weight: 500;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  transition: all 0.2s ease;
  border: none;
}

.kompkit-button:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

/* Variants */
.kompkit-button--primary {
  background-color: #3b82f6;
  color: white;
}

.kompkit-button--primary:hover:not(:disabled) {
  background-color: #2563eb;
}

.kompkit-button--secondary {
  background-color: #e5e7eb;
  color: #1f2937;
}

.kompkit-button--secondary:hover:not(:disabled) {
  background-color: #d1d5db;
}

.kompkit-button--outline {
  background-color: transparent;
  color: #3b82f6;
  border: 1px solid #3b82f6;
}

.kompkit-button--outline:hover:not(:disabled) {
  background-color: rgba(59, 130, 246, 0.1);
}

.kompkit-button--text {
  background-color: transparent;
  color: #3b82f6;
}

.kompkit-button--text:hover:not(:disabled) {
  background-color: rgba(59, 130, 246, 0.1);
}

/* Sizes */
.kompkit-button--small {
  padding: 6px 12px;
  font-size: 0.875rem;
}

.kompkit-button--medium {
  padding: 8px 16px;
  font-size: 1rem;
}

.kompkit-button--large {
  padding: 10px 20px;
  font-size: 1.125rem;
}
</style>