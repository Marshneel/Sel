@test
Feature: NA91 - WLR3_Analogue_Cease

  Scenario: Initiate and verify the flow of a WLR3 cease order
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I Initiate a cease order on the quote
    Then I should be able to check recovery line plant and caller feature validations
    And check for order completion and final assertions on order summary page