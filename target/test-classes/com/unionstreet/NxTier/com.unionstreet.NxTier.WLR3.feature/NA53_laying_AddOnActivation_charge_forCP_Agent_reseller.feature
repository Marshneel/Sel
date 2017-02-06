@E2ETests
Feature: NA53 - Laying add on activation charge for quotes created by CP, agent and reseller

  Scenario: Laying addOnActivation charge for quote created by CP
    Given I am logged in as CP
    And I create a new quote and add a service with addOnActivation charge
    When I run SQL query
    Then The charge should be visible in the back end

  Scenario: Laying addOnActivation charge for quote created by agent
    Given I am logged in as agent
    And I create a new quote and add a service with addOnActivation charge
    When I run SQL query
    Then The charge should be visible in the back end

  Scenario: Laying addOnActivation charge for quote created by reseller
    Given I am logged in as reseller
    And have created a new site for a company
    And I create a new quote for reseller  and add a service with addOnActivation charge
    When I run SQL query
    Then The charge should be visible in the back end
