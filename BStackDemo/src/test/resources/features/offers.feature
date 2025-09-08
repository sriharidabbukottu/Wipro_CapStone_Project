Feature: Offers functionality

  Scenario: Navigate to offers page
    Given I am logged in as "demouser" with password "testingisfun99"
    When I go to the offers page
    Then I should see the offers page displayed
