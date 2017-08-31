@WLR3
Feature: NA137 - WLR3 premium multiline transfer
  Scenario: initiate a transfer order on multiline and check the flow
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a transfer order on a Multiline
    Then I should be able to check the flow of the transfer order on Multiline