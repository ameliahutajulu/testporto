@Login
Feature: Login Altashop
  As a user
  I want to Login
  So that I can go to my dashboard

  Background:
    Given I am on the login page Altashop

  @Login-ValidCredentials
  Scenario: As a user I can login with valid credentials
    When I enter valid email Login
    And I enter valid password Login
    And I click Login button
    Then I redirected to dashboard page Altashop

  @Login-InvalidEmail
  Scenario: As a user I can't login with invalid email
    When I enter invalid email Login
    And I enter valid password Login
    And I click Login button
    Then I redirected back to login page Altashop
    And I receive error message

  @Login-InvalidPassword
  Scenario: As a user I can't login with invalid password
    When I enter valid email Login
    And I enter invalid password Login
    And I click Login button
    Then I redirected back to login page Altashop
    And I receive error message