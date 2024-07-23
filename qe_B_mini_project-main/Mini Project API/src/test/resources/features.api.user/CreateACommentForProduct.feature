Feature: Create A Comment For Product
  As a user
  I want to create a comment for product
  So that I can add my comment to a product

  @CreateCommentByValidId
  Scenario: As a user I can create product comment data with valid ID
    Given I set API endpoint with valid Id for create product comment
    When I send request to create valid Id product comment
    Then I receive status code 200
    And I receive data for product comment

  @CreateCommentByInvalidId
  Scenario: As a user I can create product comment data with invalid ID
    Given I set API endpoint with invalid Id for create product comment
    When I send request to create invalid Id product comment
    Then I receive status code 200
    And I receive data for product comment