@E2ETests
Feature: NA - 149 SDSK login as a CP, Agent and Reseller and search for Incidents

  Scenario: login as a CP and search for incidents
    Given I am logged in as CP
    When I navigate to service desk page and provide relevant info as a CP
    Then I should be able to search and find incidents relevant to CP

  Scenario: login as an agent and search for incidents
      Given I am logged in as agent
      When I navigate to service desk page and provide relevant info as an agent
      Then I should be able to search and find incidents relevant to agent

  Scenario: login as an agent and search for incidents
    Given I am logged in as reseller
    When I navigate to service desk page and provide relevant info as a reseller
    Then I should be able to search and find incidents relevant to reseller
