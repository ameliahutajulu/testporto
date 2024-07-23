@GetAllProducts
Feature: Get All Products
  As a user
  I want to get all products
  So that I can get information of all products

  Scenario: As a user I can get all products data
    Given I set API endpoint for get all products
    When I send request to get all products
    Then I receive status code 200
    And I receive valid data for all products