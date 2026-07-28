# Test Plan

## Overview

This document defines the testing strategy for the ShowCase application.

The project prioritizes unit testing for business logic while keeping the UI layer lightweight and predictable.

---

# Testing Scope

The following components are included in the testing scope:

- Repository
- ViewModel

The following are outside the scope:

- UI Screenshot Testing
- Instrumentation Testing
- End-to-End Testing

---

# Testing Objectives

The objectives are:

- Verify business logic correctness.
- Validate UI state transitions.
- Ensure predictable behavior.
- Prevent regressions.

---

# Test Strategy

The project uses:

- Unit Test
- Mocked Dependencies
- Deterministic Test Data

Tests should not depend on:

- Internet connection
- Real API
- Android framework components

---

# Test Cases

## Repository

### Test Case 1

Objective

Return TV show list successfully.

Expected Result

Repository returns mapped domain models.

---

### Test Case 2

Objective

Handle API failure gracefully.

Expected Result

Repository returns failure state.

---

## ViewModel

### Test Case 1

Objective

Loading state is emitted first.

Expected Result

UI receives Loading state.

---

### Test Case 2

Objective

Successful API response updates UI state.

Expected Result

UI receives Success state.

---

### Test Case 3

Objective

Failed request updates UI state.

Expected Result

UI receives Error state.

---

# Test Data

Tests should use:

- Fake Repository
- Mock API Response
- Sample TV Show Models

Avoid using production API responses.

---

# Success Criteria

Testing is considered successful when:

- All unit tests pass.
- No flaky tests exist.
- Tests remain deterministic.
- Business logic behaves as expected.

---

# Future Improvements

Potential future testing includes:

- UI Testing
- Integration Testing
- Snapshot Testing
- End-to-End Testing

These are outside the scope of this assessment.
