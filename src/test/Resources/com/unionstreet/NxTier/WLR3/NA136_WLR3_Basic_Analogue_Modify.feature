@WLR3
Feature: NA136 - WLR3 Basic Analogue Modify
  Scenario: initiate a modify order on basic analogue line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on a Basic Analogue line
    Then I should be able to check the flow of the modify order on basic analogue