@Night
Feature: NA126 - Analogue Basic To ISDN30 Change Of Line Type

  Scenario: change the line type from analogue basic to ISDN30E
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line type from analogue basic single to ISDN30E
    Then I should be able to check all the required validations and complete the change of line type order from analogue basic to ISDN30E


  Scenario: change the line type from ISDN30E to analogue basic
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from ISDN30E to analogue basic
    Then I should be able to check all the required validations and complete the change of line type order from ISDN30E to analogue basic
