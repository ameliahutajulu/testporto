Feature: Login
  As a user
  I want to login
  So that I can open my account

  @LoginValidInput
  Scenario: As a user I can login with valid input
    Given I set API endpoint for login
    When I send request to login with valid input
    Then I receive status code 200
    And I receive logged in account data

  @LoginNonExistInput
  Scenario: As a user I can't login with non exist input
    Given I set API endpoint for login
    When I send request to login with non exist input
    Then I receive status code 400
    And I receive login account error

  @LoginInvalidEmail
  Scenario: As a user I can't login with invalid email
    Given I set API endpoint for login
    When I send request to login with invalid email
    Then I receive status code 400
    And I receive login account error

  @LoginInvalidPassword
  Scenario: As a user I can't login with invalid password
    Given I set API endpoint for login
    When I send request to login with invalid password
    Then I receive status code 400
    And I receive login account error
