@Products
Feature: Products Altashop
  As a user
  I want to be able to access the products
  So that I can do some purchase

  Background:
    Given I am on the login page Altashop
    When I enter valid email Login
    And I enter valid password Login
    And I click Login button
    Then I redirected to dashboard page Altashop

  @Products-Detail
  Scenario: As a user I can see the product detail
    When I click on product detail
    Then I redirected to product detail page

  @Products-Category
  Scenario: As a user I can see product based on category
    When I click on category field
    And I click on one of the option
    Then Product with specific category will appears (if there are any)

  @Products-Purchase
  Scenario: As a user I can purchase the product
    When I click Buy on one of the product
    And I go to Cart
    And I click Pay
    Then I redirected to the Transactions Page

  @Products-EmptyCart
  Scenario: As a user I can delete product from cart
    When I click Buy on one of the product
    And I go to Cart
    And I click minus button until empty
    Then I receive alert that Order is empty