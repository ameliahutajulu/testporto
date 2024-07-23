Feature: Get product comments
  As a user
  I want to get a product comments by Id
  So that I can get information about the product comments

  @GetCommentsByValidId
  Scenario: As a user I can get product comments data with valid ID
    Given I set API endpoint with valid Id for get product comments
    When I send request to get valid Id product comments
    Then I receive status code 200
    And I receive data for product comments

  @GetCommentsByInvalidId
  Scenario: As a user I can't get product comments data with invalid ID
    Given I set API endpoint with invalid Id for get product comments
    When I send request to get invalid Id product comments
    Then I receive status code 200
    And I receive data for product comments
