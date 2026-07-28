# Engineering Decisions

This document records the technical decisions made throughout the project along with the rationale behind each decision.

The goal is to provide transparency regarding architectural choices and maintain consistency during development.

---

# Decision 001

## Title

Use MVVM Architecture

## Decision

The application will adopt the Model-View-ViewModel (MVVM) architecture.

## Rationale

MVVM provides a clear separation between UI, business logic, and data access, making the application easier to maintain, test, and scale.

This architecture also aligns with modern Android development practices and the project requirements.

---

# Decision 002

## Title

Use Jetpack Compose

## Decision

The UI will be built entirely using Jetpack Compose.

## Rationale

Jetpack Compose is the recommended modern UI toolkit for Android development.

It improves UI consistency, reduces boilerplate code, and integrates naturally with reactive state management.

---

# Decision 003

## Title

Reactive UI State

## Decision

The UI will be driven by immutable state exposed from the ViewModel.

## Rationale

Using a single observable UI state improves predictability and simplifies state handling for Loading, Success, and Error conditions.

---

# Decision 004

## Title

Repository Pattern

## Decision

Data access will be abstracted behind a repository layer.

## Rationale

Separating data sources from business logic improves maintainability and allows easier testing by replacing implementations with fakes or mocks.

---

# Decision 005

## Title

Single Source of Truth

## Decision

The Repository will become the primary source of application data.

## Rationale

Keeping one source of truth reduces duplicated logic and minimizes inconsistent application state.

---

# Decision 006

## Title

Network-First Strategy

## Decision

The application will fetch data directly from the TVMaze API.

## Rationale

The assessment only requires online data retrieval and does not require offline persistence.

Adding local caching would increase complexity without providing significant value within the project scope.

---

# Decision 007

## Title

Coroutine-Based Asynchronous Programming

## Decision

Asynchronous operations will use Kotlin Coroutines.

## Rationale

Coroutines provide a concise and readable way to perform asynchronous tasks while integrating well with ViewModel and Flow.

---

# Decision 008

## Title

StateFlow for UI State

## Decision

StateFlow will be used to expose UI state from ViewModel.

## Rationale

StateFlow works naturally with Jetpack Compose and lifecycle-aware state collection.

---

# Decision 009

## Title

Error Handling Strategy

## Decision

Errors will be represented as UI states rather than exceptions reaching the presentation layer.

## Rationale

This simplifies UI rendering and enables retry functionality while preventing application crashes.

---

# Decision 010

## Title

Unit Testing Focus

## Decision

Unit tests will primarily target ViewModel and Repository logic.

## Rationale

These layers contain the application's business logic and can be tested independently from Android framework components.

---

# Decision 011

## Title

Documentation First

## Decision

Engineering documentation is created before implementation.

## Rationale

Planning the project upfront improves consistency and allows AI tools to generate code based on clearly defined requirements.

---

# Decision 012

## Title

Incremental Git History

## Decision

Development progress will be recorded through small and meaningful commits.

## Rationale

The technical assessment explicitly evaluates commit history to understand the engineering workflow rather than only the final result.

---

# Future Decisions

Additional implementation decisions (if any) will be documented here during development.
