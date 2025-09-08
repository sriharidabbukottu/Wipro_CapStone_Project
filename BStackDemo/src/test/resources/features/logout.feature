Feature: Logout functionality

  Scenario: Logout successfully
    Given I am logged in as "demouser" with password "testingisfun99"
    When I log out
