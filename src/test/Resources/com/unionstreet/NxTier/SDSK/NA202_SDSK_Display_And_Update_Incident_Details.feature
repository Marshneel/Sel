@SDSK
    
Feature: NA - 202 Display And Update Incident Details
    
Scenario: Validating the Incident Details Panel
    Given I initiate an openreach incident and submit it
    Then I should be able to see Incident Details Panel
    And I should be able to edit the details and save the changes

Scenario: Validating that category change of an existing incident creates a default action
    Given I am on Incident Details Panel
    When I change the Category to someother Category
    Then I should be able to see that a new default action has been created on Changing the Category
