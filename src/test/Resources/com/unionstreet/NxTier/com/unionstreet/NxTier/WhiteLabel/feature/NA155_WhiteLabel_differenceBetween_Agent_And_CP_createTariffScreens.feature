@Morning
Feature: NA - 155 difference between CP and Agent create tariff screens
  Scenario: login as a CP and navigate to ADD tariff screen and verify the differences to that of screens when logged in as an agent
    Given I am logged in as CP
    When I navigate to create tariff screen
    Then I should be able to compare the differences with that of agent create tariff screen

  Scenario: login as an agent and navigate to ADD tariff screen and verify the differences to that of screens when logged in as a CP
    Given I am logged in as agent
    When I navigate to create tariff screen
    Then I should be able to compare the differences with that of CP create tariff screen