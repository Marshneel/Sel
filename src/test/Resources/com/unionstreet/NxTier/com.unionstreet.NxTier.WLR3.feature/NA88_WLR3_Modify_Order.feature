@E2ETests
Feature: NA88 - Initiate a WLR3 modify order and check the flow

  Scenario: Initiate and verify the flow in a WLR3 modify order
    Given I am logged in as CP
    And   I create a new business customer with CLI and quote
    When Initiate a modify order on the quote
    And Access the WLR order details page
    Then I should be able to check all the tabs and verify assertions
    And make sure order is completed and ready for submission


