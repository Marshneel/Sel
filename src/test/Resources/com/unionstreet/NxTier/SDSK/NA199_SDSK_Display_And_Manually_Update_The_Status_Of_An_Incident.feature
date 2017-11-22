@SDSK
Feature: NA - 199 Display And Manually Update The Status Of An Incident
    
Scenario: Validate the current status of an incident
    Given I am logged in as AdamR
    And  has raised an open reach incident
    Then should be able to validate the current status of the incident


Scenario: Validate that a default action is created on changing the status
     Given User has raised an open reach incident
     And performed an action
     When changes the current status to some other status
     Then should be able to assert that a default action has been created
