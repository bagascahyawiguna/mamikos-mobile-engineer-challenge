# Reflection

## 1. Which part of your submission are you least confident about, and why?

The part I am least confident about is the overall UI polish across different screen sizes. While the required features and both optional bonus features have been implemented, I believe the Detail Screen layout could still be refined further to better handle different poster aspect ratios and improve visual consistency.

---

## 2. Describe a moment during this project where you got completely stuck. What did you do, step by step?

One moment where I got stuck was after implementing most of the application. Although the Home Screen, Detail Screen, and ViewModels had already been created, running the application only displayed the default "Hello Android" screen.

To solve the problem, I:

1. Ran the application and confirmed the issue.
2. Reviewed the application entry point.
3. Found that `MainActivity` still contained the default Android Studio template.
4. Replaced the template with the application's navigation host (`AppNavGraph`).
5. Tested the application again to verify that navigation between Home and Detail worked correctly.

This experience reminded me that integration is just as important as implementing individual features.

---

## 3. Imagine it's Thursday, your task is due Friday, and you realize you misunderstood the requirement. Half your work is wrong. What are you doing now?

My first step would be to compare my implementation against the original requirements to identify exactly what needs to change.

Next, I would prioritize the required functionality over optional improvements. I would communicate the situation early if I were working in a team, explain the impact, and focus on delivering a correct solution instead of trying to keep features that no longer match the requirements.

I would rather submit a smaller but correct implementation than a larger solution that solves the wrong problem.

---

## 4. Your mentor asks you to change an approach you believe is worse. What do you do?

I would first try to understand the reason behind the suggestion instead of immediately defending my own approach. There may be constraints or project considerations that I am not aware of.

If I still believe there is a better alternative, I would explain my reasoning respectfully using technical arguments and discuss the trade-offs. Ultimately, if the final decision belongs to the mentor or the team, I would support that decision and implement it professionally while documenting any important considerations.

I believe good teamwork is more important than always being right.

---

## 5. What's something technical you taught yourself recently outside of class/work, and how did you learn it?

Recently I spent time learning modern Android development with Jetpack Compose and improving my understanding of Clean Architecture and MVVM.

I learned primarily by building personal projects, reading the official Android documentation, experimenting with different implementations, and comparing my solutions with best practices. During this assessment, I also learned how to use AI as a development assistant while still performing manual code reviews, testing, and validation before accepting generated code.

That experience taught me that AI can significantly improve productivity, but engineering judgment remains the developer's responsibility.
