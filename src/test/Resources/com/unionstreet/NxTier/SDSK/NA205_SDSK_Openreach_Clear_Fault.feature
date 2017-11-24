@SDSK
    
Feature: NA - 205 Openreach Clear Fault
    
Scenario: Validation the Openreach Clear Fault Functionality
    Given User has raised an open reach incident
    When clicking on clear option from Options dropdown
    Then I should be able to see a Modal with clear reasons in the dropdown and Notes Section
    And should be able to create an action and update the Status Description in the OpenReach fault details panel