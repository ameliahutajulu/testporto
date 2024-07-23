Feature: Get product by Id
  As a user
  I want to get a product by Id
  So that I can get information about the product

  @GetProductByValidId
  Scenario: As a user I can get product data with valid ID
    Given I set API endpoint with valid Id for get product
    When I send request to get valid Id product
    Then I receive status code 200
    And I receive valid data for product

  @GetProductByInvalidId
  Scenario: As a user I can't get product data with invalid ID
    Given I set API endpoint with invalid Id for get product
    When I send request to get invalid Id product
    Then I receive status code 404
    And I receive error for product