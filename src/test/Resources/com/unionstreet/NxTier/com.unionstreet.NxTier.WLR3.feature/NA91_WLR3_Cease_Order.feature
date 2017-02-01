@E2ETests
Feature: NA91 - Initiate a WLR3 cease order and check the flow

  Scenario: Initiate and verify the flow of a WLR3 cease order
    Given I am logged in as CP
    And   I create a new business customer with CLI and quote
    When I Initiate a cease order on the quote
    Then I should be able to check recovery line plant and caller feature validations
    And check for order completion and final assertions on order summary page