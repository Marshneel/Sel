@WLR3
Feature: NA103 - WLR3_ISDN30_New_Provide_Advanced_LIne_Numbering_Options
Scenario:  scenario for validating advanced line numbering option in ISDN new provide
Given I am logged in as CP
And   I create a new business customer with a quote
When I initiate a new provide ISDN line order and navigate to advanced line numbering options
Then I should be able to navigate through and perform assertions
