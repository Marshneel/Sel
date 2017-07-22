@Night
Feature: NA99 - WLR3_Analogue_Batch_Transfer

  Scenario: submit a batch order with out generating OIDs
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a batch transfer and submit it withOut selecting the order owner
    Then An error message should be thrown

  Scenario: upload a batch order with happy path TXT file
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a batch transfer and enter the CLIs with a happy path TXT file
    Then The data should be populated without any errors

  Scenario: upload a batch order with TXT file that has no CLI
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a batch transfer and upload a TXT file that has no CLI
    Then an error list message should be thrown

  Scenario: upload a batch order without and with populate missing postCode and EmergencyInfo checked in
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a batch order and upload a TXT file with populate missing PC and EI box checked
    Then An error stating the missing parameters is displayed
    When I upload the file with populate missing postCode and emergencyInfo checked in
    Then  The data should be populated without any errors
