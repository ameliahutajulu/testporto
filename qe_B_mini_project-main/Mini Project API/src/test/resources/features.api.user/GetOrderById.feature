Feature: Get order by Id
  As a user
  I want to get a order by Id
  So that I can get information about the order

  @GetOrderByValidId
  Scenario: As a user I can get order data with valid ID
    Given I set API endpoint with valid Id for get order
    When I send request to get valid Id order
    Then I receive status code 200
    And I receive valid data for order

  @GetOrderByInvalidId
  Scenario: As a user I can't get order data with invalid ID
    Given I set API endpoint with invalid Id for get order
    When I send request to get invalid Id order
    Then I receive status code 404
    And I receive error for order