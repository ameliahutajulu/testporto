Feature: Create A Category
  As a user
  I want to create a category
  So that I can make a new category

  @CreateCategoryValidInput
  Scenario: As a user I can create category with valid input
    Given I set API endpoint for create category
    When I send request to create category with valid input
    Then I receive status code 200
    And I receive created category data

  @CreateCategoryInvalidName
  Scenario: As a user I can't create category with invalid name
    Given I set API endpoint for create category
    When I send request to create category with invalid name
    Then I receive status code 400
    And I receive create category error

  @CreateCategoryInvalidDescription
  Scenario: As a user I can't create category with invalid description
    Given I set API endpoint for create category
    When I send request to create category with invalid description
    Then I receive status code 400
    And I receive create category error