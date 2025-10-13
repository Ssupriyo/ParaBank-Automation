# ParaBank Site Automation Framework

This project is a Selenium Automation Framework designed to test the ParaBank demo banking web application.  
It is built using Java, Selenium WebDriver, TestNG, Maven, and follows the Page Object Model (POM) design pattern.

---

## Project Overview

The goal of this project is to automate and validate various user flows of the ParaBank application, such as:

- User login and registration  
- Viewing account overview and transactions  
- Transferring funds between accounts  
- Paying bills  
- Requesting loans  
- Logging out

This framework supports cross-browser testing, data-driven testing, and automatic HTML reporting with screenshots for failed tests.

---

## Tech Stack

| Component | Technology Used |
|------------|-----------------|
| Language | Java |
| Automation Tool | Selenium WebDriver |
| Testing Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Test Data | Excel (.xlsx) |
| Reports | TestNG HTML Reports |
| IDE | Eclipse IDE |

---

## Project Structure

ParaBank-Automation/
│
├── src/main/java/
│ ├── com/parabank/pages/ # Page Object Classes
│ ├── com/parabank/utils/ # Helper Classes (ExcelReader, ConfigReader)
│ ├── com/parabank/managers/ # Driver Management
│ └── com/parabank/data/ # Data Providers
│
├── src/test/java/
│ ├── com/parabank/tests/ # TestNG Test Classes
│ ├── com/parabank/listeners/ # TestNG Listeners for Reports & Screenshots
│ └── com/parabank/suites/ # Test Runner Classes
│
├── resources/
│ ├── config.properties # Configuration File
│ ├── testdata.xlsx # Test Data for Data-Driven Testing
│ └── testng.xml # TestNG Suite Configuration
│
└── output/
├── test-output/ # HTML Reports
├── screenshots/ # Failure Screenshots
└── logs/ # Execution Logs
