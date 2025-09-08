Feature: Remove product from the cart

  Scenario: Remove a product from the cart
    Given I am logged in as "demouser" with password "testingisfun99"
    And I add "iPhone 12" to the cart
    When I remove "iPhone 12" from the cart
    Then I should not see "iPhone 12" in the cart
