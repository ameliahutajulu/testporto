Feature: Assign A Product Rating
  As a user
  I want to assign a product rating
  So that I can rate a product

  @AssignAProductRatingValidId
  Scenario: As a user I can rate product with valid ID
    Given I set API endpoint with valid Id for rate product
    When I send request to rate product with valid ID
    Then I receive status code 200
    And I receive rated product data

  @AssignAProductRatingInvalidId
  Scenario: As a user I can rate product with invalid ID
    Given I set API endpoint with invalid Id for rate product
    When I send request to rate product with invalid ID
    Then I receive status code 500