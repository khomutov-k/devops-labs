# Best practices Java

## Tools 

1. Use Maven wrapper, so the project could be built and executed without having to install it
2. Usage of Static Analysis Tools like FindBugs (as a maven plugin during build) to analyses common vulnerabilities and 
IDEA plugin Sonar lint to check code during development. 
3. Code coverage analysis using Jacoco

## Unit testing 
### 1. Source Code

It's a good idea to keep the test classes separate from the main source code. 
* They should be developed, executed, and maintained separately from the production code.
* Build tools like Maven and Gradle looks for src/main/test directory for test implementations.

### 2. Package Naming Convention
The package of the test class should match the package of the source class whose unit of source code it'll test

### 3. Test Case Naming Convention
The test names should be insightful, and users should understand the behavior and expectation of the test by just glancing name itself.
* Name the test cases in given_when_then to elaborate on the purpose of a unit test.
* Not only the name of a unit test, but we should also describe code blocks in the Given, When, and Then format. In addition, it helps to differentiate the test into three parts: input, action, and output.

### 4. Appropriate Assertions
Always use proper assertions to verify the expected vs. actual results.
* We should use various methods available in the Assert class of JUnit or similar frameworks like AssertJ and Hamcrest.

### 5. Specific Unit Tests
Write a unit test to test a single specific scenario.

### 6. Mock External Services
Mock the external services and merely test the logic and execution of our code for varying scenarios.

### 7. Avoid Code Redundancy
Create more and more helper functions to generate the commonly-used objects and mock the data or external services for similar unit tests.

### 8. 80% Test Coverage
Try to cover 80% of the code by unit tests
* Use tools like JaCoCo and Cobertura along with Maven or Gradle to generate code coverage reports.

### 9. Automation
Improve the reliability of the code by automating the execution of the entire test suite while creating new builds.
Primarily, this helps to avoid unfortunate regressions in various release environments. It also ensures rapid feedback before a broken code is released.

* Unit test execution should be part of CI-CD pipelines and alert the stakeholders in case of malfunctions