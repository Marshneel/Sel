@E2ETests
Feature: NA104 - ISDN30_Transfer
  Scenario: Initiate a transfer order on the CLI that has Business continuity set and validate the alert message
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a transfer service on the line that has business continuity set
    Then An alert message should be displayed

    Scenario: initiate a transfer order and check the flow of the order completion
      Given I am logged in as CP
      And   I create a new business customer with a quote
      And I initiate a transfer service on ISDN line
      When I provide all the valid info
      Then I should be able to complete the order