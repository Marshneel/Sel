@WLR3
Feature: NA135 - WLR3 Analogue basic Transfer
  Scenario: initiating a transfer order on a basic analogue line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a transfer order on a Basic Analogue line
    Then I should be able to check the flow of the transfer order on basic analogue