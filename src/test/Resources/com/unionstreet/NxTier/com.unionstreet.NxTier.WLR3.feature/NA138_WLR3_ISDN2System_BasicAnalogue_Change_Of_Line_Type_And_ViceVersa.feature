@E2ETests
Feature: NA138 - WLR3 ISDN2System Basic Analogue Change Of Line Type And ViceVersa
  Scenario: initiate a change of line type service from ISDN2 system to basic analogue
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from ISDN2 system to basic analogue
    Then Then I should be able to check all the required validations and complete the change of line type order from ISDN2 system to basic analogue

  Scenario: initiate a change of line type service from ISDN2 system to basic analogue
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from basic analogue to ISDN2 system
    Then Then I should be able to check all the required validations and complete the change of line type order from basic analogue to ISDN2 system