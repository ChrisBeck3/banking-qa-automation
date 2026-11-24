# Banking QA Automation
A standalone educational Java banking model with 12 JUnit 5 unit tests. Amounts are represented in cents. No real banking services are involved.

## Run locally
Install JDK 17 or newer and Maven 3.9+. Open this folder in VS Code with the Extension Pack for Java, or IntelliJ IDEA. In the terminal run `mvn test`. Reports appear in `target/surefire-reports`.

## Test strategy
Positive: opening balance, deposit, withdrawal, multiple transactions. Negative: insufficient funds, negative and zero transaction amounts, negative opening balance. Boundary: zero opening balance and withdrawing the full balance. Rejected transactions must leave the balance unchanged.

## Practice finding a defect
Temporarily change `amount > balance` to `amount >= balance` in BankAccount.java. Run the tests; the fullWithdrawal test should fail. Record expected vs actual behavior, restore the original condition, and rerun. Do not claim a passing run until you have executed it.

## CI
The included GitHub Actions workflow runs Maven tests on pushes and pull requests. Upload this project to your own repository to activate it.

## Scope
Unit tests only; no UI, API, database or real payment integration. This is a starter project, not a copy of any prior coursework.
