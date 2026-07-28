# Project Context

## Project Information

| Item               | Value                      |
| ------------------ | -------------------------- |
| Project Name       | ShowCase                   |
| Project Type       | Android Mobile Application |
| Platform           | Android                    |
| Language           | Kotlin                     |
| UI Framework       | Jetpack Compose            |
| Architecture       | MVVM (planned)             |
| Data Source        | TVMaze Public API          |
| Development Period | Technical Assessment       |
| Repository         | GitHub                     |

---

# 1. Project Overview

ShowCase is a simple Android application that allows users to browse television shows using the public TVMaze API.

The application focuses on delivering a clean browsing experience with a modern Android architecture and Jetpack Compose UI. The project is intentionally limited in scope to emphasize code quality, maintainability, architecture, and engineering practices rather than feature completeness.

This project is developed as part of the Mobile Engineer Intern technical assessment.

---

# 2. Business Objective

The objective of this project is to demonstrate the ability to design and develop a production-oriented Android application within a limited timeframe.

The assessment focuses on:

- Mobile application architecture
- State management
- API integration
- Code quality
- Maintainability
- Unit testing
- Engineering documentation
- AI-assisted development workflow

Rather than maximizing the number of implemented features, the priority is delivering a clean, maintainable, and well-structured codebase.

---

# 3. Product Vision

The application should provide a simple and intuitive experience for users to:

- Browse television shows.
- View detailed information about a selected show.
- Share show information with other users.

The user experience should remain responsive, readable, and resilient even when network failures occur.

---

# 4. Problem Statement

Users often need a simple way to explore television show information without unnecessary complexity.

This application solves that problem by providing:

- A lightweight browsing experience.
- Easy access to show details.
- Simple sharing functionality.
- Clear loading and error feedback.

---

# 5. Target User

The target users are general audiences who want to discover television shows and view basic information such as:

- Poster
- Title
- Rating
- Summary
- Premiere Date

No authentication or user account is required.

---

# 6. Requirement Analysis

The project requirements are grouped into four categories.

## Functional Requirements

The application must provide:

- TV Show List Screen
- TV Show Detail Screen
- Share TV Show functionality

The application must also handle:

- Loading state
- Success state
- Error state with retry mechanism

---

## Engineering Requirements

The implementation should:

- Use Kotlin.
- Use Jetpack Compose.
- Follow a sensible architecture (MVVM).
- Include at least two unit tests.
- Prioritize maintainability over feature completeness.

---

## Submission Requirements

The repository must include:

- Source code
- README.md
- AI_LOG.md
- CODE_REVIEW.md
- REFLECTION.md
- Walkthrough video link

---

## Optional Requirements

The following features are considered bonus points:

- Pagination
- Season information
- Episode information
- Cast information

These features are not part of the minimum deliverable.

---

# 7. Non-Functional Requirements

The application should be:

- Responsive
- Maintainable
- Readable
- Modular
- Testable
- Scalable
- Easy to review

The project should prioritize clean architecture and code consistency over implementing every possible feature.

---

# 8. Technical Constraints

The implementation should comply with the following constraints:

- Android platform only.
- Kotlin programming language.
- Jetpack Compose UI.
- TVMaze REST API.
- Approximately one day of development effort.
- Public GitHub repository.
- Commit history should reflect development progress.

---

# 9. Technology Stack

The planned technology stack includes:

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Coroutines
- Flow / StateFlow
- REST API

Detailed implementation decisions will be documented separately in DECISIONS.md.

---

# 10. Architecture Direction

The application will follow a layered architecture to separate presentation, business logic, and data access.

The overall design should emphasize:

- Single Responsibility Principle
- Separation of Concerns
- Unidirectional Data Flow
- Reactive UI State
- Testability

Architecture details will be documented in ARCHITECTURE.md.

---

# 11. Success Criteria

The project is considered successful if it:

- Displays TV show list successfully.
- Displays detail information correctly.
- Supports sharing a TV show.
- Properly handles loading, success, and error states.
- Includes unit tests.
- Maintains clean architecture.
- Provides complete documentation.
- Demonstrates responsible AI usage.

---

# 12. Definition of Done

The project is considered complete when:

- All mandatory features are implemented.
- Core user flows work correctly.
- Code builds successfully.
- Unit tests pass.
- Documentation is completed.
- AI usage is documented.
- Git history reflects incremental development.
- Repository is ready for technical review.

---

# References

- TVMaze API
- Mobile Engineer Intern Technical Assessment (Git Gow Ayo / Mamikos)
