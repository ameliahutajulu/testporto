@GetAllCategories
Feature: Get All Categories
  As a user
  I want to get all categories
  So that I can get information of all categories

  Scenario: As a user I can get all categories data
    Given I set API endpoint for get all categories
    When I send request to get all categories
    Then I receive status code 200
    And I receive valid data for all categories