@Night
Feature: NA140 - Multiline Change of address
  Scenario: initiate a change of address on Multiline and check the flow
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of address service on multiline
    Then I should be able to check the validations and complete the change of address for multiline