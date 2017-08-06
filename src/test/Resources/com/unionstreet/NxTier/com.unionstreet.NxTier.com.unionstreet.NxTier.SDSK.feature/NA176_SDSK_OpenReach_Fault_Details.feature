Feature: NA176 SDSK Populating OpenReach Fault Details
  Scenario: validate fault details page with analogue line type
    Given I am logged in as AdamR with zoom
    When I navigate to fault details page and choose single analogue line
   Then I should be able to check validations pertaining to single analogue line


  Scenario: validate fault details page with multi-line
    Given I am logged in as AdamR with zoom
    When I navigate to fault details page and choose multi-line
    Then I should be able to check validations pertaining to multi-line

  Scenario: validate fault details page with ISDN 30E
    Given I am logged in as AdamR with zoom
    When I navigate to fault details page and choose ISDN30E
    Then I should be able to check validations pertaining to ISDN30E


  Scenario: validate fault details page with ISDN2 system
    Given I am logged in as AdamR with zoom
    When I navigate to fault details page and choose ISDN2 System
    Then I should be able to check validations pertaining to ISDN2 System


