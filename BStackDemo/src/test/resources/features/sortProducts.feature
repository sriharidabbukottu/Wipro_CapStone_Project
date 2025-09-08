Feature: Sort products in the catalog

  Scenario: Sort products by lowest price
    Given I am logged in as "demouser" with password "testingisfun99"
    When I sort products by "lowestprice"
    Then I should see products arranged in ascending order of price

  Scenario: Sort products by highest price
    Given I am logged in as "demouser" with password "testingisfun99"
    When I sort products by "highestprice"
    Then I should see products arranged in descending order of price
