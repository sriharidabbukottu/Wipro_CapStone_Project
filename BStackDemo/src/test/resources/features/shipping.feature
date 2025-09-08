Feature: Shipping address functionality in bstackdemo

  Scenario: Fill shipping address and proceed
    Given I am logged in as "demouser" with password "testingisfun99"
    And I have added "iPhone 12" to the cart
    And I proceed to checkout
    When I enter shipping details
    Then I should see the order confirmation
    And I click on continue shopping
