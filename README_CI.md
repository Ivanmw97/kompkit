# CI/CD Documentation

## Overview

KompKit uses GitHub Actions for continuous integration with separate workflows for Web and Android components to optimize build times in our monorepo.

## Workflows

### 1. Web CI (`web.yml`)
**Triggers:**
- Push/PR to `release` or `develop` branches
- Changes in `packages/**` (excluding Android)
- Changes in `package*.json`, `lerna.json`
- Manual dispatch

**Jobs:**
- **web**: Lint, build, test, and generate docs for TypeScript/JavaScript packages

**Path Filters:** Only runs when web-related files change, avoiding unnecessary builds.

### 2. Android CI (`android.yml`)
**Triggers:**
- Push/PR to `release` or `develop` branches  
- Changes in `packages/core/android/**`
- Manual dispatch

**Jobs:**
- **android**: Lint (ktlint), static analysis (detekt), build, test, and generate docs for Kotlin packages

**Path Filters:** Only runs when Android-related files change.

## Pinned Versions

| Tool | Version | Purpose |
|------|---------|---------|
| actions/checkout | v4 | Code checkout |
| actions/setup-node | v4 | Node.js 20.x setup |
| actions/setup-java | v4 | JDK 17 (Temurin) |
| gradle/actions/setup-gradle | v4 | Gradle build cache |
| gradle/wrapper-validation-action | v1 | Security validation |
| android-actions/setup-android | v3 | Android SDK setup |

## Required Secrets

Currently no secrets are required. All builds use public dependencies and tools.

## Local Development

### Web Development
```bash
# Install dependencies
npm ci

# Run linting (if configured)
npm run lint --workspaces --if-present

# Type checking (if configured)  
npm run typecheck --workspaces --if-present

# Build packages
npm run build --workspaces --if-present

# Run tests
npm test --workspaces --if-present

# Generate docs
npm run docs:web --workspaces --if-present
```

### Android Development
```bash
# Navigate to Android module
cd packages/core/android

# Make gradlew executable (if needed)
chmod +x gradlew

# Clean build
./gradlew clean

# Lint with ktlint
./gradlew ktlintCheck

# Static analysis with detekt
./gradlew detekt

# Build debug APK
./gradlew assembleDebug

# Run unit tests
./gradlew test

# Generate documentation
./gradlew dokkaHtml
```

## Caching Strategy

- **Node.js**: Native npm cache via `actions/setup-node`
- **Gradle**: Build cache via `gradle/actions/setup-gradle`
- **No manual caching**: Avoids cache conflicts and complexity

## Artifacts

### Web Artifacts
- `web-docs-{run_id}`: Generated TypeDoc documentation (30 days)
- `web-build-{run_id}`: Built packages from dist/build directories (7 days)

### Android Artifacts  
- `android-test-reports-{run_id}`: JUnit test reports (7 days)
- `android-lint-reports-{run_id}`: ktlint and detekt reports (7 days)
- `android-debug-apk-{run_id}`: Debug APK builds (7 days)
- `android-docs-{run_id}`: Dokka-generated documentation (30 days)

## Skip Flags

Use commit message flags to skip specific builds:
- `[skip web]`: Skip web CI workflow
- `[skip android]`: Skip Android CI workflow

## Troubleshooting

### Common Issues

**1. Gradle Permission Denied**
```bash
chmod +x packages/core/android/gradlew
git add packages/core/android/gradlew
git commit -m "fix: make gradlew executable"
```

**2. Node.js Build Failures**
- Check Node.js version compatibility (using 20.x)
- Verify `package-lock.json` is committed
- Clear npm cache: `npm ci --cache .npm --prefer-offline`

**3. Android Build Failures**
- Verify JDK 17 compatibility
- Check Android SDK components (API 34, build-tools 34.0.0)
- Review ktlint/detekt reports for code quality issues

**4. Path Filters Not Working**
- Ensure file changes match the path patterns in workflow triggers
- Check that both `push` and `pull_request` events have same path filters

### Debug Commands

**Check workflow status:**
```bash
# View recent workflow runs
gh run list --limit 10

# View specific run details  
gh run view <run-id>

# Download artifacts
gh run download <run-id>
```

**Local debugging:**
```bash
# Simulate CI environment
export CI=true
export GITHUB_ACTIONS=true

# Run builds with same flags as CI
npm ci
npm run build --workspaces --if-present || npm run build
npm test --workspaces --if-present || npm test || echo "No tests found"
```

## Performance Targets

- **Web builds**: < 5 minutes for typical changes
- **Android builds**: < 8 minutes for typical changes  
- **First-time builds**: May take longer due to dependency downloads
- **Concurrent builds**: Path filters prevent unnecessary parallel execution

## Branch Strategy

- **develop**: Active development branch, all PRs target here
- **release**: Stable release branch, merges from develop
- **Dependabot**: Targets develop branch for dependency updates

## Monitoring

Monitor CI health via:
- GitHub Actions dashboard
- README badges showing build status
- Artifact retention and storage usage
- Build time trends and performance metrics
