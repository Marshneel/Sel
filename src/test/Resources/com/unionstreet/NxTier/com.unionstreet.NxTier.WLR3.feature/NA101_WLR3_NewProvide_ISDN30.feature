@NA101
Feature: NA101 - scenario for new provide ISDN30 line
  Scenario: creating a new provide ISDN30 line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a new provide ISDN line order
    Then I should be able to check the flow