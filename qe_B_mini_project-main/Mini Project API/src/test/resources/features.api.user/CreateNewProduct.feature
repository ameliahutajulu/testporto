@CreateNewProduct
Feature: Create new product
  As a user
  I want to create new product
  So that I can create new products

  Scenario: As a user I can create new product with valid inputs
    Given I set API endpoint for create new product
    When I send request to create new product with valid inputs
    Then I receive status code 200
    And I receive valid data for create new product