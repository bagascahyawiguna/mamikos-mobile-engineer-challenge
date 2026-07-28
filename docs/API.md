# API Documentation

## Overview

This project uses the public TVMaze API as its primary data source.

Base URL:

https://api.tvmaze.com/

No authentication is required.

---

# Endpoints

## 1. Get TV Shows

GET

/shows

Description:

Retrieve a list of television shows.

Example:

GET https://api.tvmaze.com/shows

Used for:

- Home Screen

---

## 2. Get TV Show Detail

GET

/shows/{id}

Description:

Retrieve detailed information for a single TV show.

Example:

GET https://api.tvmaze.com/shows/1

Used for:

- Detail Screen

---

# Data Model

Only the required fields will be used.

## TV Show

| Field          | Type   | Required |
| -------------- | ------ | -------- |
| id             | Int    | Yes      |
| name           | String | Yes      |
| image.medium   | String | Yes      |
| image.original | String | No       |
| rating.average | Double | No       |
| premiered      | String | No       |
| summary        | String | No       |

Fields not required by the application will be ignored.

---

# Error Handling

Possible scenarios:

## No Internet

Display:

- Error UI
- Retry button

---

## Timeout

Display:

- Error UI
- Retry button

---

## HTTP Error

Display:

- Friendly error message
- Retry action

---

# Response Strategy

Network DTO

↓

Mapper

↓

Domain Model

↓

UI Model

The UI should never directly consume API DTOs.

---

# API Layer Responsibilities

The Remote Layer is responsible for:

- Performing HTTP requests
- Parsing JSON
- Returning DTOs

The Repository is responsible for:

- Mapping DTO to Domain Model
- Handling errors
- Returning Result/UI State

---

# Future Endpoints (Optional)

The following endpoints may be added if bonus features are implemented:

GET /shows/{id}/episodes

GET /shows/{id}/cast

These endpoints are outside the minimum project scope.

---

# References

TVMaze API

https://www.tvmaze.com/api
