
@E2ETests
Feature: NA139 - WLR3 basic analogue Change Of Address
Scenario: initiate a change of address service on basic analogue line
  Given I am logged in as CP
  And   I create a new business customer with a quote
  When I initiate a change of address service on basic analogue line
  Then I should be able to check the validations and complete the change of address for basic analogue