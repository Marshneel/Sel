@E2ETests
Feature: NA - 150 SDSK CP, agent and reseller incident button functionality
  Scenario Outline: login as a CP, agent and reseller and check the functionality of the indecent button by placing account on hold/active with and with-out SLA
    Given I am logged in with "<userName>" and "<passWord>"
    When I access service desk page and search for a "<accountName>" with "<ID>"
    Then I should be able to check the functionality of the create incident button by searching for "<accountName>" and switching between various stages of account hold/active status with and without SLA for company with "<ID>"

    Examples:
      | userName     | passWord | accountName                     | ID |
      | CPlogin      | password | business customer created by CP | 138|
      | agentlogin   | password | business customer agent assigned| 139|
      | resellerlogin| password | business customer reseller      | 109|

