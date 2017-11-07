@SDSK

 Feature: NA - 193 SDSK OpenReach Site Information

  Scenario: Validating the absence of Access Details and Hazard Notes for Virtual Lines
   Given I am logged in as AdamR
   When I navigate to service desk page to raise an openreach incident with virtual linetype
   Then I should not be able to see Access Details and Hazard Notes for virtual lines

  Scenario: Validating OpenReach Site Information for Analogue lines
  Given I am logged in as AdamR
  And I navigate to service desk page to raise an openreach incident with Analogue linetype
  When I access site information  and save it
  Then I should be able to see Incident View and Amend Details Page

   Scenario: Validating OpenReach Site Information for ISDN2 line types
   Given I am logged in as AdamR
   And I navigate to service desk page to raise an openreach incident with ISDN2 linetype
   When I access site information for ISDN2 linetype  and save it
   Then I should be able to see Incident View and Amend Details Page

  Scenario: Validating OpenReach Site Information for ISDN30 line type.
   Given I am logged in as AdamR
   And I navigate to service desk page to raise an openreach incident with ISDN30 linetypes
   When I access site information for ISDN30 linetypes and save it
   Then I should be able to see Incident View and Amend Details Page



