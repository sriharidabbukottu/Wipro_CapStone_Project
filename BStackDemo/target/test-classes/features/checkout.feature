Feature: Checkout functionality for bstackdemo

  Scenario: Verify product in cart and proceed to checkout
    Given I am logged in as "demouser" with password "testingisfun99"
    And I have added "iPhone 12" to the cart
    When I proceed to checkout
    Then I should see the checkout page
