@Night
Feature: NA87 - WLR3_Analogue_multiline_New_provide

  Scenario: Populating the analogue multiline under WLR3 new provide order and verify for flow
    Given I am logged in as CP
    And   I create a new business customer and quote
    And add WLR new provide order to the quote
    When I access analogue multiline tab and provide all the required data
    Then I should be able to navigate throught the wizard and complete the order