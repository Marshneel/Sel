@E2ETests
Feature: NA88 - Initiate a WLR3 modify order and check the flow

  Scenario: Initiate and verify the flow in a WLR3 single line modify order
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When Initiate a modify order on the quote
    And Access the WLR order details page
    Then I should be able to check all the tabs and verify assertions
    And make sure order is completed and ready for submission

Scenario: Initiate a WLR3 multi-line modify order and verify line numbering validations
  Given I am logged in as CP
  And   I create a new business customer with a quote
  When Initiate a modify order on the quote
  And Provide a valid CLI and post code
  Then I should be able to access line numbering options and perform validations

