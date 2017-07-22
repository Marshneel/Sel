@Night
Feature: NA112 - WLR3_ISDN30_Modify
  Scenario: initiate a modify order on an ISDN30 line that you own
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on an ISDN30 line
    Then I should be able to check the flow of the ISDN30 modify