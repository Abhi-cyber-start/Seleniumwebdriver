# Selenium WebDriver Automation Framework

## Project Overview

This project is an end-to-end **test automation framework** developed using **Java, Selenium WebDriver, TestNG, and Maven**.
The framework automates the purchase flow on the Demoblaze demo e-commerce website and demonstrates best practices such as **Page Object Model (POM), reusable utilities, and different TestNG execution strategies**.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Git & GitHub

---

## Framework Design

The framework follows the **Page Object Model (POM)** design pattern to maintain separation between test logic and page elements.

### Main Components

**Base Layer**

* `BaseTest` – Handles browser setup and teardown
* `BasePage` – Contains reusable Selenium methods such as click, type, and explicit waits

**Page Objects**

* `HomePage`
* `CategoryPage`
* `ProductPage`
* `CartPage`
* `OrderPage`

**Test Classes**

* `DemoBlaze` – Automates the complete end-to-end purchase flow

---

## Automation Test Scenario

1. Open the Demoblaze website.
2. Verify the page title contains **STORE**.
3. Select a product category (Phones / Laptops / Monitors).
4. Capture all product prices displayed in the selected category.
5. Calculate price statistics:

   * Total price
   * Average price
   * Minimum price
   * Maximum price
6. Identify and select the **second most expensive product**.
7. Open the product details page and **add the product to the cart**.
8. Navigate to the **Cart page**.
9. Click **Place Order**.
10. Fill the order form with dynamically generated user data.
11. Complete the purchase process.
12. Validate the **confirmation message** displayed after purchase.
13. Verify that the **order amount matches the cart total**.

---

## Test Execution Strategy

The framework supports multiple test execution strategies using TestNG.

**Sequential Execution**
Tests run one after another in a single thread. This approach ensures stable execution and is useful during debugging or when test cases depend on application state.

**Parallel Execution**
Tests run simultaneously using multiple threads. This helps reduce overall execution time and improves efficiency when running large automation test suites.

---

## Project Structure

```
Seleniumwebdriver
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── PageObjects
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CategoryPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── OrderPage.java
│   │   │   │
│   │   │   └── TestCase
│   │   │       ├── BaseTest.java
│   │   │       ├── DemoBlaze.java
│   │   │       ├── Sequential.xml
│   │   │       └── Parallel.xml
│   │   │
│   │   └── resources
│   │       └── properties
│
├── pom.xml
└── README.md
```

---

## How to Run the Tests

1. Clone the repository
2. Import the project into an IDE (Eclipse / IntelliJ)
3. Run the TestNG XML file based on the required execution strategy:

* Run **Sequential.xml** for sequential execution
* Run **Parallel.xml** for parallel execution


## Key Features

* Page Object Model (POM) design pattern
* Reusable Selenium utility methods
* Explicit waits for stable execution
* Dynamic test data generation
* Price calculations using Java collections
* Sequential and Parallel TestNG execution
* Assertions using TestNG framework

---

## Author

**Abhilash Basala**
