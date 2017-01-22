@E2ETests
Feature: WLR3 Transfer order- address lookup by postcode, Address key and Advanced search

  Scenario Outline:  WLR3 address lookup based on post code, by logging as CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And  I assign WLR transfer order service to the newly created quote
    When  I access postcode search under installation address tab and enter incorrect post code
    Then  Error should be thrown for incorrect postCode
    And   When i enter valid post code
    Then  I should be able to search and select the address by post code
    Examples:
      | userName | passWord |
      | CP       | password |

  Scenario Outline:  WLR3 address lookup based on Address key, by logging as CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And  I assign WLR transfer order service to the newly created quote
    When   Access addressKey search under installation address tab and enter invalid address key
    Then  Error should be thrown for invalid address key
    And   When i enter valid address key
    Then  I should be able to search and select the address by address key
    Examples:
      | userName | passWord |
      | CP       | password |

  Scenario Outline:  WLR3 address lookup based on advanced search, by logging as CP, agent and reseller
    Given I am logged in with "<userName>" and "<passWord>"
    And   I create a new business customer and quote
    And  I assign WLR transfer order service to the newly created quote
    When I access advanced search under installation address tab and enter valid combinations
    Then  I should be able to search and select the address
    Examples:
      | userName | passWord |
      | CP       | password |



