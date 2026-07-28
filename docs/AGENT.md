# AGENT.md

## Purpose

This document defines the working rules for AI agents contributing to this project.

The AI agent should follow these instructions throughout the development process.

---

# Primary Objective

Implement the application according to:

- PROJECT_CONTEXT.md
- DECISIONS.md
- ARCHITECTURE.md
- API.md
- DESIGN.md
- TASK.md

Do not introduce unnecessary complexity.

Always prioritize readability and maintainability.

---

# Development Philosophy

The project emphasizes:

- Clean Architecture
- Readable code
- Incremental development
- Small commits
- Simplicity over cleverness
- Maintainability over feature completeness

The goal is not to maximize features.

The goal is to build production-quality code.

---

# Coding Rules

Always:

- Use Kotlin.
- Use Jetpack Compose.
- Follow MVVM.
- Keep UI stateless whenever possible.
- Expose immutable UI state.
- Prefer StateFlow.
- Write self-explanatory code.
- Keep functions small.
- Prefer composition over inheritance.

Never:

- Introduce unnecessary abstraction.
- Create dead code.
- Add unused dependencies.
- Modify unrelated files.
- Generate placeholder implementations unless explicitly requested.

---

# Architecture Rules

Respect the package structure defined in ARCHITECTURE.md.

Never bypass the Repository layer.

Presentation must never directly access the network.

DTO must never reach the UI layer.

Always map DTO into domain models.

---

# UI Rules

Follow DESIGN.md.

Prefer reusable composables.

Avoid deeply nested composables.

Keep composables focused on UI rendering.

Business logic belongs inside ViewModel.

---

# Networking Rules

Follow API.md.

Only use required API fields.

Ignore unnecessary response properties.

Handle failures gracefully.

Never crash because of networking errors.

---

# State Management

Every screen should expose a single immutable UI State.

Represent Loading, Success, and Error as explicit UI states.

Avoid multiple independent loading flags.

---

# Testing Rules

Business logic should be testable.

Favor ViewModel and Repository tests.

Write deterministic unit tests.

---

# Documentation Rules

Whenever implementation decisions change:

Update the appropriate documentation.

Never let documentation become outdated.

---

# Git Rules

Implement only one task at a time.

Each prompt should correspond to a focused implementation.

Avoid large unrelated changes.

---

# Communication Rules

If requirements are ambiguous:

Do not guess.

State assumptions explicitly.

Explain important engineering decisions.

---

# AI Behavior

Before generating code:

1. Read PROJECT_CONTEXT.md
2. Read DECISIONS.md
3. Read ARCHITECTURE.md
4. Read API.md
5. Read DESIGN.md
6. Read TASK.md

Only after understanding the project context should implementation begin.

If a request conflicts with these documents, ask for clarification instead of proceeding.
