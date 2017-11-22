
Feature: NA 203 Update Incident Owner
    
Scenario: Validating the list of contacts under cp
    Given I am logged in as AdamR
    And  raised an open reach incident for cp
    When I click on the owner dropdown
    Then I should be able to validate the list of contacts under cp
    And on changing the owner to some other owner
    Then I should be able to see that a new default action has been created on Changing the Owner


Scenario: Validating the list of contacts under agent
     Given I am logged in as agentAdam
     And  raised an open reach incident
     When I click on the owner dropdown
     Then I should be able to validate the list of contacts under agent
     And on changing the owner to some other owner for agent
     Then I should be able to see that a new default action has been created on Changing the Owner for Agent


Scenario: Validating the list of contacts under reseller
     Given I am logged in as adamreseller
     And  raised an open reach incident
     When I click on the owner dropdown
     Then I should be able to validate the list of contacts under reseller
     And on changing the owner to some other owner for reseller
     Then I should be able to see that a new default action has been created on Changing the Owner for Reseller
