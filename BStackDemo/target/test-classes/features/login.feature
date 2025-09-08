Feature: Login functionality for bstackdemo

  Scenario: Valid login
    Given I open the login page
    When I login with "demouser" and "testingisfun99"
    Then I should see products displayed
