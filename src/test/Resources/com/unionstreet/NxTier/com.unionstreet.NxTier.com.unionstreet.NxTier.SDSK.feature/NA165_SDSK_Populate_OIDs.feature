@Morning
@SDSK
Feature: NA - 165 Populate OIDs
  Scenario: login as a CP and obtain installation details of the selected CLI
    Given I am logged in as AdamR
    When I navigate to line and installation details of login in incident page
    Then I should be able to select a CLI and obtain its installation details