@E2ETests
Feature: NA - 169 CP vs Agent permissions Misc.
  Scenario: Login as a CP and check the required validations
    Given I am logged in as CP
    When I navigate to the required pages then I should be able to cary out required validations as a CP

  Scenario: Login as a an agent and check the required validations
    Given I am logged in as agent
    When I navigate to the required pages then I should be able to cary out required validations as an agent