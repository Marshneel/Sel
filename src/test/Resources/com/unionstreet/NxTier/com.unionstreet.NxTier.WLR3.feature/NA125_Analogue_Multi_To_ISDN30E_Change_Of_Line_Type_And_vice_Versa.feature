@E2ETests
Feature: NA125 - Analogue Multi to ISDN30E and vice-versa, change of line type

  Scenario: change the line type from analogue multi to ISDN30E
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from analogue multi to ISDN30E
    Then I should be able to check all the required validations and complete the change of line type order from analogue Multi to ISDN30E


  Scenario: change the line type from ISDN30E to analogue multi
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from ISDN30E to analogue multi
    Then I should be able to check all the required validations and complete the change of line type order from ISDN30E to analogue multi
