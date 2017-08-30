
Feature: NA179_SDSK_OpenReach Time related charges
  Scenario: validate the time related charges dropdown in relation to the ISDN30 line type
    Given I am logged in as AdamR
    When I navigate to fault details page and choose single analogue line
    Then I should be able to validate the charges
    And  I should be able to assert that the time related charges is unavailable for ISD30 and virtual lines
