Feature: Delete a product
  As a user
  I want to delete a product
  So that I can delete a certain product

  @DeleteAProductValidId
  Scenario: As a user I can delete product with valid ID
    Given I set API endpoint with valid Id for delete product
    When I send request to delete product with valid ID
    Then I receive status code 200
    And I receive deleted product data

  @DeleteAProductInvalidId
  Scenario: As a user I can delete product with invalid ID
    Given I set API endpoint with invalid Id for delete product
    When I send request to delete product with invalid ID
    Then I receive status code 200
    And I receive deleted product data

  @DeleteAProductUndefinedId
  Scenario: As a user I can't delete product with Undefined ID
    Given I set API endpoint with Undefined Id for delete product
    When I send request to delete product with Undefined ID
    Then I receive status code 405