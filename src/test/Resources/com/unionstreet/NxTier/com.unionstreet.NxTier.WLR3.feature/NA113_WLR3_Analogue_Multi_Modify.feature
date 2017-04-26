@E2ETests
Feature: NA113 - WLR3_Analogue_Multi_Modify

Scenario: Initiate a WLR3 multi-line modify order and verify line numbering validations
Given I am logged in as CP
And   I create a new business customer with a quote
When Initiate a modify order on the quote
And Provide a valid CLI and post code
Then I should be able to access line numbering options and perform validations

Scenario: Initiate a WLR3 multi-line modify order and verify validations on empty call forwarding CLI field, under automatically assign
Given I am logged in as CP
And   I create a new business customer with a quote
When Initiate a modify order on the quote
And Provide a valid CLI and post code
Then I should be able to check the validations