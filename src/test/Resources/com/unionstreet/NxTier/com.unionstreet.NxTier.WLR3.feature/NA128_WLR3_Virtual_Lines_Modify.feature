
@E2ETests
Feature: NA128 - WLR3 Virtual Lines Modify includes Remote Call Forward and Caller Redirect
  Scenario: modifying a remote call forward_virtual line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on an Remote Call Forward Virtual Line
    Then I should be able to check the flow of the remote call forward_virtual line

  Scenario: modifying a caller redirect_virtual line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on an Caller Redirect Virtual Line
    Then I should be able to check the flow of the caller redirect_virtual line
