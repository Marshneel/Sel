@WhiteLabel
Feature: NA - 178 WhiteLabel Reseller BillRun

  Scenario: validate billRuns for non-WLR customer, as a CP
    Given I am logged in as CP
    And there are billRuns already created
    When I navigate to the relevant pages then I should be able to check all the validations for non-WLR customer as a CP

  Scenario: validate billRuns for WLR customer, as a CP
    Given I am logged in as CP
    And there are billRuns already created
    When I navigate to the relevant pages then I should be able to check all the validations for WLR customer as a CP

  Scenario: validate billRuns for WLR customer, as a WhiteLabelReseller
    Given I am logged in as a WhiteLabelReseller
    And there are billRuns already created
    When I navigate to the relevant pages then I should be able to check all the validations for WLR customer as a WhiteLabelReseller


