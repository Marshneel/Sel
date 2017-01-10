@WLR3
Feature: scenarios for automatically assign number, specifying new number, selecting new number from the list and automatically assign by logging

  Scenario Outline: assigning specify new number, select from list, automatically assign now by logging as CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And   I assign WLR transfer order service to the newly created quote
    When  I access specify new number, select from list and automatically assign now with out populating installation address, an error should be thrown
    And   when i populate the installation address field and access the same
    Then  The error should not be seen

    Examples:
      | userName      | passWord |
      | CP            | password |


  Scenario Outline: : accessing No change, Automatically assign and automatically assign now features under line numbering by logging in as a CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And   I assign WLR transfer order service to the newly created quote
    When  I access line numbering page
    Then  I should be able to check all required validations
    Examples:
      | userName      | passWord |
      | CP            | password |


#  Scenario Outline: accessing appointments by logging as CP, Agent and Reseller
#    Given I am logged in with "<userName>" and "<passWord>"
#    And   I create a new business customer and quote
#    And   I assign WLR transfer order service to the newly created quote
#    When I access appointments page on the WLR order details page
#    Then I should be able to perform the required validations
#    Examples:
#      | userName      | passWord |
#      | CP            | password |
#      | resellerlogin | password |


