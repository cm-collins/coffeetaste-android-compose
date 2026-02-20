# CoffeeTaste-Android ☕️

A modern **Jetpack Compose (Material 3)** sample coffee shop app built with **Kotlin** to practice real-world Android development: clean architecture, feature-based separation, type-safe navigation, and full **light/dark mode** support.

## What we're building
A UI flow based on provided designs:
- Get Started (Landing)
- Sign In
- Sign Up
- Home (search, categories, featured items, sections)
- (Next) Favorites, Cart, Profile, Product Details

## Tech & Practices
- Kotlin + Jetpack Compose (Material 3)
- Feature-based architecture (auth, home, etc.)
- Unidirectional Data Flow (UiState / UiEvent / UiEffect)
- Navigation with nested graphs (AuthGraph → MainGraph)
- Reusable design system components
- Fake data source first (easy to swap with API later)

## Requirements
- Android Studio (latest stable)
- Kotlin (latest supported by Android Studio)
- Min SDK: 24+

## Run
1. Clone the repo
2. Open in Android Studio
3. Sync Gradle
4. Run on emulator/device

## Design Notes
This project intentionally focuses on **clean separation**, **scalable navigation**, and **theme-first UI** (no hardcoded colors in screens).

---

Made for practice with ❤️ using Jetpack Compose.