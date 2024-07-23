Feature: Delete a category
  As a user
  I want to delete a category
  So that I can delete a certain category

  @DeleteACategoryValidId
  Scenario: As a user I can delete category with valid ID
    Given I set API endpoint with valid Id for delete category
    When I send request to delete category with valid ID
    Then I receive status code 200
    And I receive deleted category data

  @DeleteACategoryInvalidId
  Scenario: As a user I can delete category with invalid ID
    Given I set API endpoint with invalid Id for delete category
    When I send request to delete category with invalid ID
    Then I receive status code 200
    And I receive deleted category data

  @DeleteACategoryUndefinedId
  Scenario: As a user I can't delete category with Undefined ID
    Given I set API endpoint with Undefined Id for delete category
    When I send request to delete category with Undefined ID
    Then I receive status code 405