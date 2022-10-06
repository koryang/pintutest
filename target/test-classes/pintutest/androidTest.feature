@androidTest
Feature: Android automation

  @login
  Scenario: Login - Success
    Given app is launched
    And user register using data
      | test1 | test1@test.com |
    When user fill the login email with "test1@test.com"
    And user fill the login password with "test1"
    And user click login button
    Then user should see the home page

  @login-failed
  Scenario Outline: Login - Failed
    Given app is launched
    When user fill the login email with "<email>"
    And user fill the login password with "<password>"
    And user click login button
#    Then user should this error message "<message>" where "<status>"
    And user should stay on login page

    Examples:
      | email          | password | status              | message                 |
      | test1@test.com | test1    | not registered user | Wrong Email or Password |
      |                | test1    | empty email         | Enter Valid Email       |
      | test1@test.com |          | empty password      | Enter Valid Email       |

  @register
  Scenario Outline: Register
    Given app is launched
    And user click No account yet link
    When user fill the name with "<name>"
    And user fill the email with "<email>"
    And user fill the password with "<password>"
    And user fill the confirm password with "<confirm_password>"
    And user click register button
    Then user validate "<status>"
    And user should stay register page

    Examples:
      | name  | email          | password | confirm_password | status                   |
      | test1 | test1@test.com | test1    | test1            | success                  |
      | test1 | test1          | test1    | test1            | invalid email format     |
      | test1 | test1@test.com | test1    | test12           | invalid confirm password |
      |       | test1@test.com | test1    | test1            | empty name               |
      | test1 |                | test1    | test1            | empty email              |
      | test1 | test1@test.com |          |                  | empty password           |
      | test1 | test1@test.com | test1    |                  | empty confirm password   |
