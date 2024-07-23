@Register
Feature: Register Altashop
  As a user
  I want to Register
  So that I can make new account

  Background:
    Given I am on the register page Altashop

  @Register-ValidCredentials
  Scenario: As a user I can register with valid credentials
    When I enter valid email
    And I enter valid password
    And I enter valid full name
    And I click Register button
    Then I redirected to login page Altashop

  @Register-UsedEmail
  Scenario: As a user I can't register with used email
    When I enter used email
    And I enter valid password
    And I enter valid full name
    And I click Register button
    Then I redirected back to register page Altashop
    And I receive error message

  @Register-EmptyFullName
  Scenario: As a user I can't register with empty full name
    When I enter valid email
    And I enter valid password
    And I let full name empty
    And I click Register button
    Then I redirected back to register page Altashop
    And I receive error message

  @Register-InvalidEmail
  Scenario: As a user I can't register with invalid email
    When I enter invalid email
    And I enter valid password
    And I enter valid full name
    And I click Register button
    Then I redirected back to register page Altashop
    And I receive error message

  @Register-EmptyPassword
  Scenario: As a user I can't register with empty password
    When I enter valid email
    And I let password empty
    And I enter valid full name
    And I click Register button
    Then I redirected back to register page Altashop
    And I receive error message