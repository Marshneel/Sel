@WLR3
Feature: NA109 - WLR3_ISDN2_New_Provide_Line_Suitability_Dialogue

Scenario: verify the absence and presence of the line suitability dialogue without and with addressKey assigned respectively, under siteDetails
 Given I am logged in as CP
 And   I create a new business customer with a quote
 When I initiate any of the ISDN2 new provide without addressKey
 Then An error message requesting the address match is highlighted
 And When I assign an address key under siteDetails of that customer, and initiate the ISDN2 new provide order
 Then The line suitability dialogue should be highlighted

Scenario: verify the line suitability dialogue in an ISDN2 new provide after the address look up with a valid post code
 Given I am logged in as CP
 And   I create a new business customer with a quote
 When I initiate any of the ISDN2 new provide without addressKey
 And perform an address search and choose the address under installation address
 Then The line suitability dialogue should be highlighted