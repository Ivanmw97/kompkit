# Contributing

Contributions to KompKit Core are welcome. Please follow these guidelines.

## Commit conventions

Use conventional commit messages:
- `feat:` for new features
- `fix:` for bug fixes
- `chore:` for maintenance tasks
- `docs:` for documentation updates
- `test:` for test additions or updates

Example:
```
feat(core): add throttle utility for web and android
```

## Code guidelines

1. **Always add or update tests.** Every new utility or bug fix must include corresponding tests for both web (Vitest) and Android (JUnit).

2. **Maintain Web/Android API parity.** Function signatures, parameters, and behavior should be consistent across platforms. If a feature cannot be implemented identically, document the differences clearly.

3. **Keep dependencies minimal.** Avoid adding new runtime dependencies unless absolutely necessary.

4. **Follow existing code style.** Use TypeScript for web, Kotlin for Android. Follow the patterns established in the existing codebase.

## Local development

### Setup
```bash
# Clone the repository
git clone https://github.com/your-org/kompkit.git
cd kompkit

# Install dependencies
npm install
```

### Build
```bash
# Build web package
npm run build
```

### Test
```bash
# Run all tests (web + android)
npm test

# Run only web tests
npm run test:web

# Run only android tests
npm run test:android
```

### Workflow
1. Create a feature branch: `git checkout -b feat/my-feature`
2. Make your changes
3. Add tests for both platforms
4. Run `npm test` to verify all tests pass
5. Commit with a conventional commit message
6. Push and open a pull request

## Pull request checklist

- [ ] Tests added for web and android
- [ ] All tests pass (`npm test`)
- [ ] Code follows existing style
- [ ] Commit messages follow conventions
- [ ] Documentation updated if needed
