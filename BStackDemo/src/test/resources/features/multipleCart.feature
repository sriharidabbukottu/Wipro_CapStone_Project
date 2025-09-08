Feature: Add multiple products to the cart

  Scenario: Add two different products to the cart
    Given I am logged in as "demouser" with password "testingisfun99"
    When I add iPhone 12 and Samsung Galaxy S20 to the cart
    Then I should see iPhone 12 and Samsung Galaxy S20 in the cart
