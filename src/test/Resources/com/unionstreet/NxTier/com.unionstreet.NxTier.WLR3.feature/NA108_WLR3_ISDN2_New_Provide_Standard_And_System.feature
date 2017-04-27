@E2ETests
Feature: NA108 - WLR3_ISDN2_New_Provide_Standard_And_System

  Scenario: create a new ISND2 standard line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a new provide ISDN Standard line order
    Then I should be able to check and validate the flow of ISDN_Standard line

  Scenario: create a new ISND2 system line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a new provide ISDN System line order
    Then I should be able to check and validate the flow of ISDN_System line