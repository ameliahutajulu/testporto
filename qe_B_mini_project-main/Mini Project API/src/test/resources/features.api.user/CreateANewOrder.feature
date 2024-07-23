Feature: Create A New Order
  As a user
  I want to create a new order
  So that I can add my new order

  @CreateOrderValidInputs
  Scenario: As a user I can create a new order with valid Inputs
    Given I set API endpoint for create a new order
    When I send request to create a new order with valid inputs
    Then I receive status code 200
    And I receive data for created order

  @CreateOrderInvalidProductId
  Scenario: As a user I can create product comment data with invalid Product Id
    Given I set API endpoint for create a new order
    When I send request to create a new order with invalid Product Id
    Then I receive status code 400
    And I receive error create order

  @CreateOrderInvalidQuantity
  Scenario: As a user I can create product comment data with invalid quantity
    Given I set API endpoint for create a new order
    When I send request to create a new order with invalid quantity
    Then I receive status code 400
    And I receive error create order