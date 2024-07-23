@GetHelloIndex
Feature: Get Index
  As a user
  I want to get Index
  So that I can get hello Index

  Scenario: As a user I can get hello Index data
    Given I set API endpoint for get hello Index
    When I send request to get hello Index
    Then I receive status code 200
    And I receive valid data for hello Index