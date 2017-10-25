@WLR3
Feature: NA39 - Creation Of User, Agent, Reseller permissions

  Scenario: Creating an agent permission group and assigning it to an agent
    Given I am logged in as an admin
    And   have added a new business customer with required contact type
    And   have created a new agent permission group
    When I wish to create agent contact with valid login credentials
    Then the agent permission group should be available for selection under drop down under agentUser creation
    And I should be able to login with agent credentials

  Scenario: user should not be able to create a business customer with agent and reseller contact types checked
    Given I am logged in as an admin
    When i navigate to the add customer page and click both agent and reseller
    Then A validation message should be thrown

  Scenario: Creating a CP permission group and assigning it a CP
    Given I am logged in as an admin
    And   Have created a new CP permission group under settings
    When I wish to create new CP under login users sub-menu
    Then the CP permission should be available for selection under drop down during the CP creation
    And I should be able to login with CP credentials

  Scenario: Creating an order quote by logged in as an agent and verifying all required fields are visible on the quote screen
    Given I am logged in as agent
    And Have created a new customer
    When I access create Quote tab for agent
    Then All required fields pertaining to an agent should be visible on the create quote window
    And Only the quotes created by me and the ones created for my company should be visible

  Scenario: Creating an order quote by logged in as a reseller and verifying all required fields are visible on the quote screen
    Given I am logged in as reseller
    When I access create Quote tab for Reseller
    Then All required fields pertaining to a reseller should be visible on the create quote window
    And Only the quotes created for companies under my contact list should be visible

  Scenario: Creating an order quote by logged in as a CP and verifying all required fields are visible on the quote screen
    Given I am logged in as CP
    And I have added a new business customer
    When I access create Quote tab for CP
    Then All required fields pertaining to a CP should be visible on the create quote window
    And all the quotes including that of the resellers and agents should be visible

