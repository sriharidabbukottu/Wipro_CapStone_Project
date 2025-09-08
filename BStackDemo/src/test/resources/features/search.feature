Feature: Search functionality for bstackdemo

  Scenario: Search for a product by name
    Given I am logged in as "demouser" with password "testingisfun99"
    When I search for "iPhone"
    Then I should see products related to "iPhone"
