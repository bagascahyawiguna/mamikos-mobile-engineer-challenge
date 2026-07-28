# AI Prompt Playbook

## Overview

This document contains the prompt sequence used throughout the development process.

Each prompt is intentionally scoped to a single engineering task to maintain clean AI interactions, predictable outputs, and traceable development history.

Before executing any prompt, the AI agent must read:

- PROJECT_CONTEXT.md
- DECISIONS.md
- ARCHITECTURE.md
- API.md
- DESIGN.md
- TASK.md
- AGENT.md

---

# Phase 1 — Project Setup

## Prompt 1

### Objective

Configure the Android project foundation.

### Task Reference

Task 1

### Prompt

Configure the Android project according to the engineering documentation.
Verify the project builds successfully.
Do not implement application features yet.

### Expected Output

- Working Gradle configuration
- Valid package structure
- Successful project build

### Definition of Done

Project builds without errors.

---

## Prompt 2

### Objective

Setup dependencies.

### Task Reference

Task 2

### Prompt

Add the required dependencies based on PROJECT_CONTEXT.md,
DECISIONS.md and ARCHITECTURE.md.

Only include dependencies that are actually needed.

### Expected Output

Gradle dependencies configured.

### Definition of Done

Project sync succeeds.

---

## Prompt 3

### Objective

Create project architecture.

### Task Reference

Task 3

### Prompt

Create the package structure defined in ARCHITECTURE.md.

Do not implement business logic.

### Expected Output

Folder structure created.

### Definition of Done

Project architecture matches ARCHITECTURE.md.

---

# Phase 2 — Networking

## Prompt 4

Implement the networking layer according to API.md.

Task Reference:

Task 4

---

## Prompt 5

Implement Repository following DECISIONS.md.

Task Reference:

Task 5

---

# Phase 3 — Home Feature

## Prompt 6

Implement Home ViewModel.

Task Reference:

Task 7

---

## Prompt 7

Implement Home Screen UI.

Task Reference:

Task 6

---

# Phase 4 — Detail Feature

## Prompt 8

Implement Detail Screen.

Task Reference:

Task 8

---

## Prompt 9

Implement Share Feature.

Task Reference:

Task 9

---

# Phase 5 — Testing

## Prompt 10

Implement Repository Unit Tests.

Task Reference:

Task 10

---

## Prompt 11

Implement ViewModel Unit Tests.

Task Reference:

Task 11

---

# Phase 6 — Documentation

## Prompt 12

Complete project documentation.

Task Reference:

Task 12

---

# Phase 7 — Final Review

## Prompt 13

Perform a complete engineering review before submission.

Task Reference:

Task 13

Verify:

- Project builds
- Tests pass
- Documentation complete
- Git history clean
- No obvious issues remain

---

# Prompt Engineering Rules

Every prompt should:

- Solve one problem only.
- Avoid unrelated refactoring.
- Produce deterministic output.
- Preserve existing project structure.
- Respect all engineering documentation.

Never ask the AI to generate the entire project in a single prompt.
