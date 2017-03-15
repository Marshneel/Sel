Feature: NA102 - initiating an unsolicited cease and verifying the progress with SQL query of the aBILLity dataBase
  Scenario: create a modify order and initiate an unsolicited cease on the line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And  There is a completed processed modify order available
    When I initiate an unsolicited cease on the line and push notifications using CmdController
    Then The cease should be placed on the line