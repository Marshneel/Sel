Feature: laying add on activation charge for quote created by CP, agent and reseller

  @smokePack
  Scenario: laying addOnActivation charge for quote created by CP
    Given I am logged in as CP
    And I create a new quote and add a service with addOnActivation charge
    When I run SQL query
    Then The charge should be visible in the back end


  @smokePack
  Scenario: laying addOnActivation charge for quote created by agent
    Given I am logged in as agent
    And I create a new quote and add a service with addOnActivation charge
    When I run SQL query
    Then The charge should be visible in the back end


  @smokePack
  Scenario: laying addOnActivation charge for quote created by reseller
    Given I am logged in as reseller
    And I create a new quote and add a service with addOnActivation charge
    When I run SQL query
    Then The charge should be visible in the back end
