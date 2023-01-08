# API_BDD_Demo_Intel471

# 1. Test case

- ## Using http://dummy.restapiexample.com provide a test framework that tests the following:

- successfully retrieves all employees and counts the number of employees with age number higher than 30
- successfully adds new employee with age higher than 30 and assert that operation is successful
- successfully updates the employee and asserts that operation is successful
- successfully retrieves all employees and asserts that employees with age number higher than 30 has modified
- successfully deletes the employee that he added and asserts the operation is successful 

<pre><code>Feature: Shopping cart

  Feature: Dummy Rest API Functionality Scenarios

  Scenario Outline: Dummy Rest Api GET Employees
    Given Get Call to "<url>"
    Then Response Code "<responseCode>" is validated

    Examples:
      | url               | responseCode |
      | /api/v1/employees | 200          |

  Scenario Outline:  Verify the number of employees with age more than 30
    Given Get Call to "<url>"
    Then There are "<num>" employees with age more than 30

    Examples:
      | url               | num |
      | /api/v1/employees | 16  |

  Scenario Outline: Dummy Rest Api Add new employee over 30
    Given Post Call to "<url>" with payload new employee
    Then Response Code "<responseCode>" is validated

    Examples:
      | url            | responseCode |
      | /api/v1/create | 200          |

  Scenario Outline: Dummy Rest Api Update employee
    Given Update Call to "<url>" with payload employee updated
    Then Response Code "<responseCode>" is validated

    Examples:
      | url               | responseCode |
      | /api/v1/update/21 | 200          |

  Scenario Outline: Dummy Rest Api DELETE Employees
    Given Delete Call to "<url>"
    Then Response Code "<responseCode>" is validated

    Examples:
      | url              | responseCode |
      | /api/v1/delete/2 | 200          |
</code></pre>

# 2. Automation tests folder structure
- ## REST Assured, Cucumber, Java, Gradle to build the automation test framework
- ## We can also evaluate Postman, katalon, Karate to build the automation test framework depends on the requirments from the product.

#### Run `build.gradle` from IDE Java 
#### Run test with `DemoRestAPITest.feature`

#### You can watch the *API_BDD_Demo.mov* to see the test execution
[![API_BDD_Demo](https://res.cloudinary.com/marcomontalbano/image/upload/v1673212680/video_to_markdown/images/google-drive--1aolowvxe1uFJdssam3T1WYiBi4G2KFAl-c05b58ac6eb4c4700831b2b3070cd403.jpg)](https://drive.google.com/file/d/1aolowvxe1uFJdssam3T1WYiBi4G2KFAl/view?usp=sharing "API_BDD_Demo")


#### Test report you can check the link after execution of the tests from Cucumber Report
<pre><code>
┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/1b4b416c-bc78-40e6-b4ae-a0d9b92a0e78 │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │

Process finished with exit code 0
└──────────────────────────────────────────────────────────────────────────┘
</pre></code>

<img width="1234" alt="image" src="https://user-images.githubusercontent.com/38011268/211156704-4da241dd-55b2-4aca-b102-085bce6b11ea.png">

#### Project structure

    ├── src
    │   ├── test/java
    │   │   ├── runner/TestRunner.java
    │   │   └── step_definitions/DemoRestAPITest.java
    │   └── test/resources
    │       ├── featureFiles
    │       │   └── DemoRestAPITest.feature
    │       ├── Payloads
    │       │   ├── NewEmployee.json
    │       │   └── UpdateEmployee.json
    │       ├── cucumber.properties
    │       └── junit-platform.properties
    ├── build.gradle
    ├── settings.gradle
    └── README.md
