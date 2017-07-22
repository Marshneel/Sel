@Night
Feature: NA61 - WLR3_Analogue_Transfer_Obtaining_Initial_information

  Scenario Outline: Populating network calling features and directory information by logging as a CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And   I assign WLR transfer order service to the newly created quote
    When  I populate network calling features and directory information
    Then  The saved information should be seen on the WLR order details page
    And   When i depopulate the network calling features and edit directory information
    Then  The changes should be manifested on the WLR order details page
    Examples:
      | userName | passWord |
      | CP       | password |

  Scenario Outline: Populating site information by logging as a CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And   I assign WLR transfer order service to the newly created quote
    When  I access site information page and populate it
    Then  The saved information should be seen under site information on the WLR order details page
    And   When i depopulate the information page
    Then  The information should vanish under site information from the WLR order details page
    Examples:
      | userName | passWord |
      | CP       | password |
