Feature: Register
  As a user
  I want to register
  So that I can make a new account

  @RegisterValidInput
  Scenario: As a user I can register with valid input
    Given I set API endpoint for register
    When I send request to register with valid input
    Then I receive status code 200
    And I receive registered account data

  @RegisterExistedInput
  Scenario: As a user I can't register with existed input
    Given I set API endpoint for register
    When I send request to register with existed input
    Then I receive status code 400
    And I receive register account error

  @RegisterInvalidEmail
  Scenario: As a user I can't register with invalid email
    Given I set API endpoint for register
    When I send request to register with invalid email
    Then I receive status code 400
    And I receive register account error

  @RegisterInvalidPassword
  Scenario: As a user I can't register with invalid password
    Given I set API endpoint for register
    When I send request to register with invalid password
    Then I receive status code 400
    And I receive register account error

  @RegisterInvalidFullName
  Scenario: As a user I can't register with invalid full name
    Given I set API endpoint for register
    When I send request to register with invalid full name
    Then I receive status code 400
    And I receive register account error
