@E2ETests
Feature: NA98 - Test script to verify the steps involved in amend order

  Scenario: Create an order and amend it, verify the steps involved.
    Given I am logged in as CP
    And   I create a new business customer with CLI and quote
    And  Create an order and submit it
    When I access edit order page and click the order ID
    Then I should be able to edit the order successful