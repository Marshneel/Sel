Feature: NA166 SDSK OpenReach LineTest
  Scenario: perform a line test on an analogue line
    Given I am logged in as AdamR with zoom
    When I raise an open reach incident on an analogue line
    Then I should be able to validate the line test functionality

  Scenario: assert that the LineTest is unavailable for ISDN30 and virtual lines
    Given I am logged in as AdamR with zoom
    When I navigate to obtain installation details page
    Then I should be able to assert that the lineTest is un-available for ISDN30 and virtual lines



