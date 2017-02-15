@E2ETests
Feature: NA98 - Test script to verify the steps involved in amend& submit and order, and receive notification responses using CmdController

  Scenario: Create an order, amend, submit and process it, verify the steps involved.
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And  Create an order and submit it
    When I access edit order page and click the order ID
    Then I should be able to edit and submit the order successful
