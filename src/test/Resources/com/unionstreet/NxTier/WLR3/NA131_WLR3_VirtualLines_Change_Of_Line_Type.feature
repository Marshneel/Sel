@WLR3
Feature: NA131 - WLR3 VirtualLines change of line type
  Scenario: perform a change of line type from remote call forwarding to caller redirect
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from Virtual line-Remote call forwarding to Virtual line-caller redirect
    Then I should be able to check the flow and change remote call forwarding to caller redirect

  Scenario: perform a change of line type from caller redirect to remote call forwarding
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from Virtual line-caller redirect to Virtual line-Remote call forwarding
    Then I should be able to check the flow and change from caller redirect to remote call forwarding