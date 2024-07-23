@GetUserInformation
Feature: Get User Information
  As a user
  I want to get user information
  So that I can get the information of user

  Scenario: As a user I can get user information data
    Given I set API endpoint for get user information
    When I send request to user information
    Then I receive status code 200
    And I receive valid data for user information