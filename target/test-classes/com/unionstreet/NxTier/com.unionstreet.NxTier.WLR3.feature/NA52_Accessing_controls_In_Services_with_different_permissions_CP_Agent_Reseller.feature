Feature: Accessing controls in services with different permissions (CP, Agent and reseller)

  Scenario: verify that a charge designated CP only is accessible by CP
    Given I am logged in as CP
    And create a new quote and access a service
    Then the CP only control should be visible and accessible
    And this should be verified by checking the back end

  Scenario: verify that a charge designated CP only is inaccessible by agent
    Given I am logged in as agent
    And create a new quote and access a service
    Then the CP only control should be invisible
    And the absence of the charge should be verified in the back end

  Scenario: verify that a charge designated CP only is inaccessible by reseller
    Given I am logged in as reseller
    And create a new quote and access a service
    Then the CP only control should be invisible
    And the absence of the charge should be verified in the back end