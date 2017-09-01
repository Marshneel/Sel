@WLR3
Feature: NA121 - WLR3_Single_Line_BasicAndPremium_New_Provide

  Scenario: create a new provide order for analogue single basic
    Given I am logged in as CP
    And   I create a new business customer and quote
    And add WLR new provide order to the quote
    When I access analogue basic single line tab and provide all the required data
    Then I should be able to navigate through the wizard and complete the order for analogue single basic

  Scenario: create a new provide order for analogue single premium
    Given I am logged in as CP
    And   I create a new business customer and quote
    And add WLR new provide order to the quote
    When I access analogue premium single line tab and provide all the required data
    Then I should be able to navigate through the wizard and complete the order for analogue single premium