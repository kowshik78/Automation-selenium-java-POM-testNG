<h1>Selenium Automation Framework</h1>
<h2>https://magento.softwaretestingboard.com</h2>

This framework is built to automate end-to-end testing for e-commerce web application using Selenium WebDriver, TestNG, and Java. It follows the Page Object Model (POM) design pattern to improve the readability, maintainability, and reusability of the test code. The framework integrates with Maven for build and dependency management, supports Allure for reporting, and uses log4j for logging.

The framework also includes support for Excel-driven testing using Apache POI, dynamic browser handling through properties, and robust assertion handling.

## Technology Stack

* Programming Language: Java
* Automation Tool: Selenium WebDriver
* Test Framework: TestNG
* Build Tool: Maven
* Design Pattern: Page Object Model (POM)
* Reporting: Allure Reporting
* Logging: log4j
* Data-Driven Testing: Excel (Apache POI)

## Key Features
* Page Object Model (POM) Design: Encapsulates web element locators and methods in their respective classes, making test scripts more readable and maintainable.
* Data-Driven Testing: Test data is stored in Excel sheets. The framework uses Apache POI to read and write data from Excel files, enabling dynamic test execution.
* Cross-Browser Testing: The framework supports dynamic browser selection (e.g., Chrome, Firefox) via a properties file, allowing flexibility in test execution.The browser type can be specified through config.properties or passed as a parameter in TestNG.
* Assertions and Validations: Assertions are integrated into tests to validate critical steps such as: Correct login, Billing address updates, Order total verification. Both hard and soft assertions are used, depending on the criticality of the validation.
* Screenshots on Failure: The framework captures screenshots automatically on test failure or upon certain checkpoints for debugging purposes.
* Logging and Reporting: log4j provides detailed logs of test execution, including steps, warnings, and errors.
* Allure Reporting generates comprehensive HTML reports with step-by-step test execution details, screenshots, and logs.

## Design Pattern: Factory Method in the Framework

* This Selenium automation framework leverages the Factory Method design pattern, especially when dealing with WebDriver initialization for different browsers.
* The Factory Method pattern is used to create objects without exposing the creation logic to the client. Instead, it defers the instantiation of objects (in this case, different browser drivers) to subclasses or methods, making the framework more flexible, maintainable, and extendable.
* In BaseTest class, the factory method is used to determine which WebDriver to instantiate based on the browser type provided as a parameter in the testng.xml file.
```
<parameter name ="browser" value="chrome"/>
```
* In the BaseTest class:
```
if(browser.equals("chrome")) {
   driver = new ChromeDriver();
} else if(browser.equals("firefox")) {
   driver = new FirefoxDriver();
}
```
* Browser Flexibility: Extend the framework to support more browsers by adding more conditions for new browsers. No need to modify core test logic; just extend factory method logic for new WebDriver instantiations.
* Centralized Control: All browser instantiation logic is managed in one place (i.e., BaseTest), ensuring any changes to browser setup are made in a single location without impacting individual test classes.
* Decoupling of Object Creation: Test logic is decoupled from object creation process which allows tests focus on behavior, while the factory method takes care of setting up the right browser environment.

### Factory Method and Page Object Model:

* Factory Method pattern complements Page Object Model (POM) approach. Each page class represents a page and provides methods to interact with the elements on that page.
* Since WebDriver instantiation is handled separately in the BaseTest, each page class can be initialized with a WebDriver instance.
```
LoginPage loginPage = new LoginPage(driver);
loginPage.login("user", "pass");
```
* Here, the driver object is already initialized by the factory method, and the Page Object can directly use it to interact with the login elements.
--------------------------------------------------------------------------------------------------------------------------------------------------
<br></br>

## Test Flow ( Excel-Based ) :
The test flow leveraging data from Excel includes:

* Sign-Up: Using data from an Excel sheet.
* Login: Also using Excel data for credentials.
* Billing Address Update: Updates the billing address based on data from Excel.
* Product Selection: Dynamically selects a product from a list (women’s category).
* Add to Cart and Checkout: Proceeds to add the product to the cart and completes the checkout process.

## Test Flow ( Non Excel-Based ) :

* Create Account: Creates a new user account.
* Change Password: Changes the user’s password.
* Login: Logs in with the updated credentials.
* Set Billing Address: Updates billing address.
* Broken Link Test: Verifies that no broken links exist on the homepage.
* Subscription Click: Subscribes to the newsletter.
* Compare Products: Adds products to the cart and compares multiple products.
* Order Validation: Places the order, checks out, and validates the order data against the order history.

## Reporting
* Allure Reporting is integrated to provide comprehensive test reports, including step-by-step logs, screenshots, and failure reasons.
* TestNG Listener: In the testng.xml file, Allure’s listener is enabled:
```
<listeners>
    <listener class-name="io.qameta.allure.testng.AllureTestNg"/>
</listeners>
```

## Logging

* The framework uses log4j for logging all test steps, errors, and warnings. Logs are generated both in the console and in rolling log files.
* Logs are saved in the /screenshots folder, with each test execution creating a separate log file based on the current date and time.
* Log Levels:
  - INFO: Informational messages.
  - WARN: Warning messages that do not interrupt the test flow.
  - ERROR: Errors that cause the test to fail.
  
## Utilities
* Excel Utility (Apache POI) supports reading and writing to Excel files, making the framework flexible for data-driven testing.
* Screenshot Utility automatically captures screenshots on test failures or at key test steps.
