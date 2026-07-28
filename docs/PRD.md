# Product Requirement Document (PRD)

> Source: Intern Mobile Engineer Test – Mobile Engineer Intern Take Home Challenge (Mamikos)

---

# Part 1 — Build "TV App"

Build a simple TV show browser application with **two screens** using the **TVMaze API**.

## API

### List Endpoint

```
GET https://api.tvmaze.com/shows?page=0
```

### Detail Endpoint

```
GET https://api.tvmaze.com/shows/{id}
```

### API Documentation

https://www.tvmaze.com/api

---

# Feature Requirements

## 1. List Screen

Fetch TV shows from the list endpoint and display:

- Show poster (`image.medium`)
- Show title (`name`)
- Show rating (`rating.average`)

### Notes

- `rating.average` may be `null`.
- Handle the null state properly.
- Loading one page (~250 shows) is sufficient.
- Pagination is optional (bonus).
- The API is rate-limited to approximately **20 requests every 10 seconds**, which should not be reached during normal application usage.

---

## 2. Detail Screen

When the user taps a TV show, navigate to the detail screen.

Display:

- Large poster (`image.original`)
- Title
- Summary (`summary`)
- Premiere date (`premiered`)

### Notes

The `summary` field contains HTML tags such as:

- `<p>`
- `<b>`

Render the HTML correctly or strip the HTML tags before displaying.

### Bonus

Display:

- Seasons
- Episodes
- Cast

---

## 3. Share Action

Provide a Share action from the Detail Screen.

Shared content must include:

- TV show title
- TV show summary
- TVMaze URL

---

# Technical Requirements

## Platform

Android:

- Kotlin
- Jetpack Compose

---

## Application State

Handle all three UI states:

- Loading
- Error (with Retry)
- Success

---

## Architecture

Use a sensible architecture.

Example:

- MVVM

The evaluation prioritizes clean project structure over perfection.

---

## Unit Testing

Provide at least **2 unit tests** for:

- ViewModel

or

- Data Layer

---

## Documentation

The repository must include a `README.md` explaining:

- How to run the application
- Architecture decisions
- Improvements that would be made with more time

---

## Git History

Commit incrementally throughout development.

The commit history will be reviewed to understand the development process.

Avoid submitting one large final commit.

---

## Time Limit

Spend **no more than one day** on this challenge.

It is preferable to complete **70% cleanly** rather than **100% with poor quality**.

---

# Part 2 — AI Usage Log

AI tools are allowed and encouraged.

Examples:

- ChatGPT
- Claude
- Copilot
- Cursor
- Other AI assistants

Submit a file named:

```
AI_LOG.md
```

Include **4–8 entries**.

Each entry should contain:

1. What I asked the AI / the problem I was solving.
2. What the AI generated.
3. What I did with the output:
   - Accepted
   - Modified (how?)
   - Rejected (why?)
4. One thing the AI got wrong or something I verified myself.

Do not write generic entries such as:

> "Asked AI, it worked."

An honest log explaining where AI failed is considered a positive signal.

---

# Part 3 — AI Code Review Exercise

Create:

```
CODE_REVIEW.md
```

Imagine an AI generated the following Android code.

Review it as if it were a Pull Request.

List:

- Every issue you identify.
- How you would fix it.

```kotlin
class MovieViewModel : ViewModel() {

    var movies: List<Movie> = emptyList()

    fun loadMovies() {
        val url = URL("https://api.example.com/movies")
        val data = url.readText()
        movies = parseMovies(data)
    }

}
```

---

# Part 4 — Written Reflection

Create:

```
REFLECTION.md
```

Answer honestly.

## Questions

### 1

Which part of your submission are you least confident about, and why?

---

### 2

Describe a moment during this project (or another project) where you became completely stuck.

Explain step by step how you solved it.

---

### 3

Imagine:

It is Thursday.

The task is due Friday.

You suddenly realize you misunderstood the requirements and half of your work is incorrect.

What do you do?

---

### 4

Your mentor asks you to change an approach even though you believe your current solution is better.

What do you do?

---

### 5

What technical topic have you recently taught yourself outside of school or work?

How did you learn it?

---

# Part 5 — 5 Minute Walkthrough Video

Record your screen and voice.

Examples:

- Loom
- OBS
- Phone recording

Video quality and editing are not important.

Maximum duration:

**5 minutes**

Show:

1. The application running (including the Error state).
2. One file you are most proud of and explain it line by line.
3. One example where AI generated something incorrect and how you fixed it.

---

# Submission

Submit a single GitHub repository containing:

- Android source code
- README.md
- AI_LOG.md
- CODE_REVIEW.md
- REFLECTION.md
- A link to the walkthrough video inside the README.md
