@WLR3
Feature: NA_192 Quote Screen For Nxtier And WLR3 Items In Same Order

  Scenario: Initiate Orders for Nxtier and WLR3 items and validate the Quote for CP
    Given I am logged in as CP
    And I create a new business customer with a quote
    When I add a service from the quote details page for both Nxtier and WLR3
    Then I should be able to see both the items in same order for CP
    And I should be able to cancel the order
    Then I should not be able to see that particular order