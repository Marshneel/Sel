@E2ETests
Feature: NA99 - create a batch order and submit it without completion
  Scenario: submit a batch order with out generating OIDs
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a batch transfer and submit it with out generating OIDs
    Then An error message should be thrown