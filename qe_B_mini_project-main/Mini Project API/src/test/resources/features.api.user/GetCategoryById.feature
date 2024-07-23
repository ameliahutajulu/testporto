Feature: Get category by Id
  As a user
  I want to get a category by Id
  So that I can get information about the category

  @GetCategoryByValidId
  Scenario: As a user I can get category data with valid ID
    Given I set API endpoint with valid Id for get category
    When I send request to get valid Id category
    Then I receive status code 200
    And I receive valid data for category

  @GetCategoryByInvalidId
  Scenario: As a user I can't get category data with invalid ID
    Given I set API endpoint with invalid Id for get category
    When I send request to get invalid Id category
    Then I receive status code 404
    And I receive error for category