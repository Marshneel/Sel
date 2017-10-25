@WLR3
Feature: NA52 - Accessing controls in services with different permissions (CP, Agent and reseller)

  Scenario: Verify that a charge designated CP only is accessible by CP
    Given I am logged in as CP
    And create a new quote and access a service for CP
    Then the CP only control should be visible and accessible

  Scenario: Verify that a charge designated CP only is inaccessible by agent
    Given I am logged in as agent
    And create a new quote and access a service for agent
    Then the CP only control should be invisible

  Scenario: Verify that a charge designated CP only is inaccessible by reseller
    Given I am logged in as reseller
    And have created a new site for a company
    And Have created a quote for reseller
    And create a new quote and access a service for reseller
    Then the CP only control should be invisible
