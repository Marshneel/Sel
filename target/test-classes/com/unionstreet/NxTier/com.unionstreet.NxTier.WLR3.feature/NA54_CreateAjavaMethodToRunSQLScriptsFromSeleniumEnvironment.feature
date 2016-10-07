Feature: creation of method to run sql queries to check database inserts

   Scenario: logging in as CP, adding a charge to quote and checking if its implemented in the back-end
    Given I am logged in as CP
    And create a new quote and add a service that contains a service charge
    When I add the charge
    And query the database
    Then the charge should be visible
    And upon removing the charge the charge should disappear from the backend

  Scenario: logging in as agent , adding a charge to quote and checking if its implemented in the back-end
    Given I am logged in as agent
    And create a new quote and add a service that contains a service charge
    When I add the charge
    And query the database
    Then the charge should be visible
    And upon removing the charge the charge should disappear from the backend

  Scenario: logging in as reseller , adding a charge to quote and checking if its implemented in the back-end
    Given I am logged in as reseller
    And create a new quote and add a service that contains a service charge
    When I add the charge
    And query the database
    Then the charge should be visible
    And upon removing the charge the charge should disappear from the backend