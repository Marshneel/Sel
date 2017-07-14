@E2ETests
Feature: NA - 161 create a package as an Agent and CP

  Scenario: login as an agent and create a business and consumer packages
    Given I have been assigned tariffs and free minutes by the CP
    When I am logged in as agent with out Zoom
    And I navigate to the package manager
    Then I should be able to create business and consumer packages

  Scenario: agent should not be able to edit a package assigned by CP
    Given I am logged in as CP
    When I assign a package to agent
   Then He should not be able to edit it

  Scenario: agent should be able to edit a package created by him
    Given I am logged in as agent
    When  I create a package
    Then I should be able to edit it

  Scenario: agent should not be able to re-add a package that is assigned by CP to his customer, unless he has the permissions
    Given I am logged in as CP
    When I Add a package to a business customer
    Then The agent will be able to see and delete the package only but cannot re- assign it unless he has permissions