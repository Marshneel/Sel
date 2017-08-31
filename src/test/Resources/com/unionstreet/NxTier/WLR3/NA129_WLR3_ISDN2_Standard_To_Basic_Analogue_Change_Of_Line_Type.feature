@WLR3
Feature: NA129 - ISDN2 Standard to Basic Analogue change of line type and vice versa
  Scenario: initiate a change of line type service on ISDN2 standard line and change it to basic analogue
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from ISDN2 standard to basic analogue
    Then Then I should be able to check all the required validations and complete the change of line type order from ISDN2 standard to basic analogue

    Scenario: initiate a change of line type service on basic analogue and change it to ISDN2 standard
      Given I am logged in as CP
      And   I create a new business customer with a quote
      When I initiate a change of line from basic analogue to ISDN2 standard
      Then Then I should be able to check all the required validations and complete the change of line type order from basic analogue to ISDN2 standard