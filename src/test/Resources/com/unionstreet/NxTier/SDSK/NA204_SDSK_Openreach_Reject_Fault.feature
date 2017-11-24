@SDSK
    
Feature: NA - 204 Openreach Reject Fault
    
Scenario: Validating Openreach Reject fault functionality for Analogue LineType
     Given i raise an openreach incident for Analogue LineType
     When clicking on reject option from the Options dropdown
     Then Should be able to see a modal with dropdown field populated with reasons and Notes section
     And should update the status description in the openreach fault details panel

Scenario: Validating Openreach Reject fault functionality for Digital LineType
     Given i raise an openreach incident for Digital LineType
     When clicking on reject option from the Options dropdown
     Then Should be able to see a modal with dropdown field populated with reasons and Notes section
     And should update the status description in the openreach fault details panel