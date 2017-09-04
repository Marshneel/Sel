
Feature: NA - 151 SDSK URL Manipulation
  Scenario Outline: login as a CP and perform URL manipulation tests
    Given I am logged in with "<userName>" and "<passWord>" without access rights
    When I try to navigate to service desk page the access should be denied with  "<userName>" and "<passWord>"
    And when I am granted the service desk access and I login with "<userName>" and "<passWord>"
    Then Based on the status of the account and SLA, I should be able to or unable to log a ticket for business customer with "<ID>" and "<SiteID>" via pasting the URL

    Examples:
      | userName      | passWord | ID | SiteID |
      | CPlogin       | password |138 | 166    |
      | agentlogin    | password |139 | 167    |
      | resellerlogin | password |109 | 168    |