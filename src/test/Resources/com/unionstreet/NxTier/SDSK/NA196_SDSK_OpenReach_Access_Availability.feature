
 @SDSK
Feature: NA - 196 OpenReach Access Availability
    
Scenario: Validating the presence of Access Availability for ISDN30E linetype
    Given I am logged in as AdamR
    When I raise an Openreach Incident with the linetype ISDN30E
    Then I should be able to see the validations related to Access Availability upon saving the Incident