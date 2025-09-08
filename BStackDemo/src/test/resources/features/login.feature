Feature: Login functionality for different users

  Scenario: Login as demouser
    Given I open the login page
    When I login as "demouser" with password "testingisfun99"
    Then I should be logged in successfully

  Scenario: Login as image_not_loading_user
    Given I open the login page
    When I login as "image_not_loading_user" with password "testingisfun99"
    Then I should be logged in successfully

  Scenario: Login as existing_orders_user
    Given I open the login page
    When I login as "existing_orders_user" with password "testingisfun99"
    Then I should be logged in successfully

  Scenario: Login as fav_user
    Given I open the login page
    When I login as "fav_user" with password "testingisfun99"
    Then I should be logged in successfully

  Scenario: Login as locked_user
    Given I open the login page
    When I login as "locked_user" with password "testingisfun99"
    Then I should see locked user error
