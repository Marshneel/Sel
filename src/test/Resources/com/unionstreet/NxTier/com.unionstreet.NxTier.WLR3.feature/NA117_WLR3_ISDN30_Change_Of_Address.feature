@Night
Feature: NA117- WLR3_ISDN30_Change_Of_Address
Scenario: initiate a change of address for ISDN30 line
  Given I am logged in as CP
  And   I create a new business customer with a quote
  When I initiate a change of address service for ISDN30
  Then I should be able to check the validations and complete the change of address for ISDN30
