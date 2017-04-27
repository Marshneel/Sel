@E2ETests
Feature: NA100 - WLR3_Basic_Premium_Single_Multi_ChangeOfLineType

  Scenario: scenario for change of line type from basic analogue line to premium analogue line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from basic single to premium single
    Then I should be able to check all the required validations and complete the change order for basic to premium analogue

  Scenario: scenario for change of line type from premium analogue to basic analogue
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from premium analogue to basic analogue
    Then I should be able to check all the required validations and complete the change order for premium to basic analogue

  Scenario: scenario for change of line type from basic analogue to premium multi
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from basic analogue to premium multiple
    Then I should be able to check all the required validations and complete the change order for basic to multiple

  Scenario: scenario for change of line type from premium multi to basic analogue
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line type from multi to basic analogue
    Then I should be able to check all the required validations and complete the change order from multi to analogue basic

    Scenario: scenario for change of line type on a CLI that is not owned
      Given I am logged in as CP
      And   I create a new business customer with a quote
      When I initiate a change of line type service on the CLI that is not owned
      Then A validation message requesting confirmation of ownership is displayed
