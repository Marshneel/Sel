@E2ETests
Feature: NA127 - WLR3 Virtual Lines NewProvide Remote Call Forward and ISDN Caller Redirect
  Scenario: create a new provide virtual line: ISDN Remote Call Forward
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a virtual line order for ISDN Remote Call Forward
    Then I should be able to check the flow and complete the virtual line order for ISDN remote call forward

  Scenario: create a new provide virtual line: ISDN Caller Redirect
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a virtual line order for ISDN Caller Redirect
    Then I should be able to check the flow and complete the virtual line order for ISDN Caller Redirect