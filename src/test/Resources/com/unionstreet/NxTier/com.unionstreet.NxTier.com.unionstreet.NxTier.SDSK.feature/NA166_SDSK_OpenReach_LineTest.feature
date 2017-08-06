Feature: NA166 SDSK OpenReach LineTest
  Scenario: perform a line test on an analogue line
    Given I am logged in as AdamR with zoom
    When I raise an open reach incident on an analogue line
    Then I should be able to validate the line test functionality
