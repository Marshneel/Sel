@test
Feature: NA99 - create a batch order and submit it without completion
  Scenario: submit a batch order with out generating OIDs
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a batch transfer and submit it withOut selecting the order owner
    Then An error message should be thrown

    Scenario: upload a batch order with happy path CSV file
      Given I am logged in as CP
      And   I create a new business customer with a quote
      When I initiate a batch transfer and enter the CLIs with a happy path CSV file
      Then The data should be populated without any errors

    Scenario: upload a batch order with csv file that has no CLI
      Given I am logged in as CP
      And   I create a new business customer with a quote
      When I initiate a batch transfer and upload a csv file that has no CLI
      Then an error list message should be thrown