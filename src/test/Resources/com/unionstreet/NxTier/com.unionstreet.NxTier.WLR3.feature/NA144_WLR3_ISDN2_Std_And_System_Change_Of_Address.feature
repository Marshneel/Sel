@E2ETests
Feature: NA144 - WLR3 ISDN2 standard and system change of address
  Scenario: initiate a change of address service on standard line and verify whether that channels are not editable
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of address service on ISDN2 standard line
    Then I should be able to check and verify whether the number of channels is not editable

  Scenario: initiate a change of address service on standard line and verify whether that channels are not editable
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of address service on ISDN2 system line
    Then I should be able to check and verify whether the number of channels is editable