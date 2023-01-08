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
      | /api/v1/update/1 | 200          |

  Scenario Outline: Dummy Rest Api DELETE Employees
    Given Delete Call to "<url>"
    Then Response Code "<responseCode>" is validated

    Examples:
      | url              | responseCode |
      | /api/v1/delete/2 | 200          |
