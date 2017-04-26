@E2ETests
Feature: NA122 - WLR3_ISDN2_Standard_And_System_Modify

  Scenario: ISND2 Standard line modify
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on an ISDN2 Standard line
    Then I should be able to check the flow of the ISDN2 Standard modify

  Scenario: ISDN2 System line modify
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a modify order on an ISDN2 System line
    Then I should be able to check the flow of the ISDN2 System modify