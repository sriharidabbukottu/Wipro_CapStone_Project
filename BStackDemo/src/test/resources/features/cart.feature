Feature: Cart functionality for bstackdemo

  Scenario: Add product to cart
    Given I am logged in as "demouser" with password "testingisfun99"
    When I add "iPhone 12" to the cart
    Then I should see "iPhone 12" in the cart
