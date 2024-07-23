Feature: Get product rating by Id
  As a user
  I want to get a product rating by Id
  So that I can get information about the product rating

  @GetRatingByValidId
  Scenario: As a user I can get product rating data with valid ID
    Given I set API endpoint with valid Id for get product rating
    When I send request to get valid Id product rating
    Then I receive status code 200
    And I receive data for product rating

  @GetRatingByInvalidId
  Scenario: As a user I can't get product rating data with invalid ID
    Given I set API endpoint with invalid Id for get product rating
    When I send request to get invalid Id product rating
    Then I receive status code 200
    And I receive data for product rating