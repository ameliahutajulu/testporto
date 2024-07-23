@GetAllOrders
Feature: Get All Orders
  As a user
  I want to get all orders
  So that I can get information of all orders

  Scenario: As a user I can get all orders data
    Given I set API endpoint for get all orders
    When I send request to get all orders
    Then I receive status code 200
    And I receive valid data for all orders