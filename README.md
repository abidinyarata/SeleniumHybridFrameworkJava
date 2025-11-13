# Selenium Java End To End Web Application Test Automation Architecture

![Static Badge](https://img.shields.io/badge/Java-green)
![Static Badge](https://img.shields.io/badge/Selenium-red)
![Static Badge](https://img.shields.io/badge/TestNG-yellow)
![Static Badge](https://img.shields.io/badge/Extent%20Reports-pink)
![Static Badge](https://img.shields.io/badge/POM-blue)
![Static Badge](https://img.shields.io/badge/DataDrivenTest-aqua)
![Static Badge](https://img.shields.io/badge/Maven-red)


## Overview

Web test automation example project using Java, Selenium 4, Maven, TestNG, Extent Reports, DDT and Page Object Model (POM)

### 🧱 Tech Stack

- **Language:** Java  
- **Build Tool:** Maven  
- **Test Framework:** TestNG  
- **UI Automation:** Selenium WebDriver  
- **Reporting:** ExtentReports  
- **Data Handling:** Apache POI (Excel-based test data)  
- **Logging:** Log4j  
- **Utilities:** Apache Commons libraries
  
### 📁 Project Structure

The project is structured as follows:
```
|   .classpath
|   .project
|   crossbrowsertests.xml
|   grouping.xml
|   final.xml
|   listener.xml
|   master.xml
|   pom.xml
|       
+---reports
|       
+---screenshots
|       
+---src
|   +---main
|   \---test
|       +---java
|       |   +---pageObjects
|       |   |       AccountRegistrationPage.java
|       |   |       BasePage.java
|       |   |       HomePage.java
|       |   |       LoginPage.java
|       |   |       MyAccountPage.java
|       |   |       
|       |   +---testBase
|       |   |       BaseClass.java
|       |   |       
|       |   +---testCases
|       |   |       AccountRegistrationTest.java
|       |   |       LoginDataDrivenTest.java
|       |   |       LoginTest.java
|       |   |       
|       |   \---utilities
|       |           DataProviders.java
|       |           ExcelUtility.java
|       |           ExtentReportManager.java
|       |           
|       \---resources
|               config.properties
|               log4j2.xml
|               
+---target
|               
+---test-output
|           
\---testData
        
```

### 🔧 Features

* **Hybrid Framework**

    Combines data-driven, modular, and page object design patterns.

* **Page Object Model (POM)**

    Separate page classes to centralize locators and actions.

* **Data-Driven Testing**

    Test data stored in Excel files under testData/ and read using Apache POI.

* **Cross-Browser Support**

    Suite file like crossbrowsertests.xml allows running the same tests on multiple browsers.

* **TestNG Integration**

    Suite XML files (master.xml, grouping.xml, loginDDT.xml, etc.) for flexible execution.

* **Rich Reporting**

    ExtentReports for HTML-based execution reports.

* **Logging**

    Log4j logging for debugging and traceability.

### Clone the repository using

```
git clone https://github.com/abidinyarata/SeleniumHybridFrameworkJava.git
```
