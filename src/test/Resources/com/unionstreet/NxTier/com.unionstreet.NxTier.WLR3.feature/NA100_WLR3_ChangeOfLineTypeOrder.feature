Feature: Scenarios for change of line type order

  Scenario: scenario for change of line type from basic single line to to premium single line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from basic single to premium single
    Then I should be able to check all the required validations and complete the order for basic to premium

  Scenario: scenario for change of line type from premium single to basic single
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from premium single to basic single
    Then I should be able to check all the required validations and complete the order for premium to basic

  Scenario: scenario for change of line type basic single to premium multiple
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a change of line from single basic to premium multiple
    Then I should be able to check all the required validations and complete the order for basic to multiple