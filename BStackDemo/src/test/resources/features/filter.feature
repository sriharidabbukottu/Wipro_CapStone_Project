Feature: Filter products by brand

  Scenario: Filter products by multiple brands
    Given I am logged in as "demouser" with password "testingisfun99"
    When I filter products by the following brands:
      | Apple   |
      | Samsung |
    Then I should see only products from the following brands:
      | Apple   |
      | Samsung |
