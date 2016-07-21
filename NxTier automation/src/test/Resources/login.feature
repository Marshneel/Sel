Feature: Login functionality

  Scenario: Verify that login is successful with valid username and password
    Given I am on login page
    When I enter valid username and password
    Then login is successful