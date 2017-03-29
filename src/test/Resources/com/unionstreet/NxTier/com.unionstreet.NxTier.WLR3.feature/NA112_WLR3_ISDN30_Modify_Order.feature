@NA108
Feature: NA112 - modify an ISDN30 line
  Scenario: initiate a modify order on an ISDN30 line that you own
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on an ISDN30 line
    Then I should be able to check the flow of the ISDN30 modify