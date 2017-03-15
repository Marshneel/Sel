@E2ETests
Feature: NA103 - Scenario for advanced line numbering options for ISDN30
Scenario:  scenario for validating advanced line numbering option in ISDN new provide
Given I am logged in as CP
And   I create a new business customer with a quote
When I initiate a new provide ISDN line order and navigate to advanced line numbering options
Then I should be able to navigate through and perform assertions
