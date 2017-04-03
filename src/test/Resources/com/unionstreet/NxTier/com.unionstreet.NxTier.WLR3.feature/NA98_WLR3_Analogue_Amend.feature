@E2ETests
Feature: NA98 - Test script to verify the steps involved in submit and amend an order, and receive notification responses using CmdController

  Scenario: Create an order submit, amend and process it, verify the steps involved.
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And  Create an order and submit it
    When I access edit order page and click the order ID
    Then I should be able to amend and submit the order successful

  Scenario: create a transfer order and initiate an unsolicited cease on the line
    Given I am logged in as CP
    And  There is a processed transfer order available
    When I initiate an unsolicited cease on the line and push notifications to cancel it using CmdController
    Then The cease should be cancelled on the line
