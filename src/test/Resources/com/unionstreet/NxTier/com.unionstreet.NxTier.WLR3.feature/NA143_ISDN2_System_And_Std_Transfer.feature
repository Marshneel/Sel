@E2ETests
Feature: NA143 - ISDN2 system and Std transfer
  Scenario: initiate a transfer order on ISDN2 system line and capture all required validations
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a transfer service on ISDN2 system line
    Then I should be able to check the flow for the ISDN2 system transfer order

  Scenario: initiate a transfer order on ISDN2 standard line and capture all required validations
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a transfer service on ISDN2 standard line
    Then I should be able to check the flow for the ISDN2 standard transfer order
