
 @SDSK

Feature: NA - 197 SDSK Display And Update Contact Details
    
Scenario: Validating the Contact Details  on View and Amend Details Page
    Given I am logged in as AdamR
    And I submit an OpenReach Incident for Analogue Line
    When I am on View And Amend Details Page upon editing it
    Then I should be able to validate the fields
    And I should be able to assert those saved changes in the Incident Contact Information component