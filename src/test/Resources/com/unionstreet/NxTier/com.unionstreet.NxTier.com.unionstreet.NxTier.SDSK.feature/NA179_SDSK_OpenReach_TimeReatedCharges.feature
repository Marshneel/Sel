Feature: NA179_SDSK_OpenReach Time related charges
  Scenario: validate the time related charges dropdown in relation to the ISDN30 line type
    Given I am logged in as AdamR
    When I navigate to line and installation details page and generate OIDs for ISDN30 line
    Then I should be able to asset that the time related charges field is absent
    And When I select a different line type and generate OIDs
    Then I should be able to validate the charges
