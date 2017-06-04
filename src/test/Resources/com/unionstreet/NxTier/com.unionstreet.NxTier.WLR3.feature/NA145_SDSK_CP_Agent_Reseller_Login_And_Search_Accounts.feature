
Feature: NA - 145 SDSK CP Agent and Reseller And Search Accounts

  Scenario: login as a CP and search the service desk menu for accounts
    Given I am logged in as CP
    And have created a business customer and assigned required data
    When I am on the service desk page
    Then I should be able search by Account name, Account number & CLI and get all the relevant details in the CP search

  Scenario: login as an agent and search the service desk menu for accounts
    Given I am logged in as agent and CP has already assigned me a business customer
    When I am on the service desk page as an agent
    Then I should be able search by Account name, Account number & CLI and get all the relevant details in the agent search

  Scenario: login as a reseller and search the service desk menu for accounts
    Given I am logged in a reseller and CP has already created a site under me
    When I am on the service desk page as a reseller
    Then I should be able search by Account name, Account number & CLI and get all the relevant details in the reseller search