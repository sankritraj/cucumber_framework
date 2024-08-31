# Cucumber Framework with Maven, Selenium 4, Selenium Grid, and Docker

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)

## Introduction

This project is a test automation framework that utilizes Cucumber with Selenium 4 for behavior-driven development (BDD) testing. It leverages Maven for dependency management, Selenium Grid for running tests on different browsers and platforms, Log4j for logging, and Docker to containerize the Selenium Grid setup.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java**: JDK 8 or higher installed.
- **Maven**: Installed and configured.
- **Docker**: Installed and running.
- **Git**: Installed for version control.

## Project Structure
project-root/
│
├── pom.xml                            // Maven configuration file
├── log4j.properties                   // Configuration file for logging
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── context/               // Context-specific classes for shared data
│       │   ├── factory/               // Factory classes for object management
│       │   ├── hooks/                 // Setup and teardown methods (Cucumber hooks)
│       │   ├── pageObjects/           // Page Object Model classes
│       │   ├── stepDefinitions/       // Step definition classes for Cucumber
│       │   ├── testRunner/            // Classes to run tests (e.g., Cucumber test runners)
│       │   └── utilities/             // Utility classes (e.g., WebDriver utilities, wait functions)
│       │
│       └── resources/
│           ├── features/              // Feature files for Cucumber (written in Gherkin language)
│           ├── log/                   // Directory for log files generated during test execution
│           └── reports/               // Directory to store test execution reports (e.g., HTML, XML)
│
└── other directories/                 // Any other necessary directories or files

## Setup and Installation

1. **Clone the Repository**:
   
   Clone this repository to your local machine using the following command:

   ```bash
   git clone https://github.com/your-username/Cucumber-Selenium-Docker.git---

2. Navigate to the Project Directory:
   
```bash
cd Cucumber-Selenium-Docker
```
3. Install Dependencies:

Use Maven to install the necessary dependencies:

```bash
mvn clean install
```
4. Configure Test Settings:

Update the config files as per your test environment requirements. Configuration files can include settings for Selenium Grid, browser types, URLs, etc.

## Running Tests

To run tests using Maven, use the following command:
```
mvn test
```
This command will trigger the Cucumber test runner, executing all the scenarios defined in the feature files.

5. Set Up Log4j Configuration:

Ensure you have a log4j2.xml file in the src/test/resources directory. Here's a sample configuration:

<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="FileLogger" fileName="logs/app.log" immediateFlush="false" append="false">
            <PatternLayout pattern="%d{YYYY-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="FileLogger"/>
        </Root>
    </Loggers>
</Configuration>

