# Architecture

## Overview

ShowCase follows a layered MVVM (Model-View-ViewModel) architecture to separate responsibilities between presentation, business logic, and data access.

The architecture emphasizes:

- Separation of Concerns
- Single Responsibility Principle
- Unidirectional Data Flow
- Testability
- Maintainability
- Scalability

The application is intentionally kept simple while following production-oriented engineering practices.

---

# Architecture Diagram

```
Presentation Layer
│
├── Screens
├── Components
├── Navigation
└── ViewModel
        │
        ▼
Domain Layer
│
├── Repository Interface
├── Use Cases (optional)
└── Domain Models
        │
        ▼
Data Layer
│
├── Repository Implementation
├── Remote Data Source
├── DTO
├── Mapper
└── TVMaze API
```

---

# Project Structure

```
app/
└── src/main/java/io/github/bagascahyawiguna/showcase/

    data/
        remote/
            api/
            dto/
        mapper/
        repository/

    domain/
        model/
        repository/

    presentation/
        navigation/
        screen/
        component/
        state/
        viewmodel/

    common/
        network/
        util/

    MainActivity.kt
```

The package structure is feature-light and layer-oriented to keep the project simple for the scope of this assessment.

---

# Layer Responsibilities

## Presentation Layer

Responsible for:

- Rendering UI
- User interaction
- Navigation
- Collecting UI state
- Displaying Loading, Success, and Error states

This layer should not communicate directly with network services.

---

## Domain Layer

Responsible for:

- Business rules
- Repository abstraction
- Domain models

The domain layer must not depend on Android framework classes.

---

## Data Layer

Responsible for:

- API communication
- DTO management
- Data mapping
- Repository implementation

Only this layer communicates with the remote API.

---

# Data Flow

The application follows a one-way data flow.

```
User Action

↓

ViewModel

↓

Repository

↓

Remote API

↓

Repository

↓

ViewModel

↓

UI State

↓

Compose UI
```

The UI observes immutable state exposed by the ViewModel.

---

# State Management

Each screen should expose a single immutable UI State.

Example states include:

- Loading
- Success
- Error

No mutable UI state should exist inside Composable functions except temporary UI-only interactions.

---

# Error Handling

Network failures should never crash the application.

Instead, errors are converted into UI State and displayed through dedicated error components.

The application should provide a Retry action whenever appropriate.

---

# Navigation

Navigation will follow a simple Compose Navigation graph.

Expected destinations:

- TV Show List
- TV Show Detail

Navigation arguments should only include lightweight identifiers whenever possible.

---

# Dependency Direction

```
Presentation

↓

Domain

↓

Data
```

Dependencies must always point inward.

Outer layers must never be referenced by inner layers.

---

# Testing Strategy

Primary testing targets:

- ViewModel
- Repository

The UI layer should remain thin to simplify testing.

---

# Scalability

The architecture should support future enhancements including:

- Pagination
- Search
- Favorites
- Offline cache
- Dependency Injection
- Multiple data sources

These features are outside the scope of the current assessment but should be possible without major architectural changes.

---

# Architecture Principles

The project follows these engineering principles:

- Separation of Concerns
- SOLID (where applicable)
- Clean Code
- Readability over cleverness
- Explicit state management
- Predictable data flow
- Modular package organization

---

# Out of Scope

To keep the project aligned with the assessment timeline, the following are intentionally excluded:

- Authentication
- Local Database
- Offline Mode
- Push Notification
- Analytics
- Background Sync
- Multi-module architecture

These decisions reduce unnecessary complexity while maintaining clean engineering practices.
