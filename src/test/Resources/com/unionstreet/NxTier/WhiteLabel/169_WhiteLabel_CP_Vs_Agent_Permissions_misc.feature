Feature: NA - 169 WhiteLabel CP vs Agent permissions misc.
  Scenario Outline: compare the cp permissions to that of the agent
    Given I am logged in with "<userName>" and "<passWord>"
    When I navigate to particular pages then I should be able to perform the required assertions
    Examples:
      | userName      | passWord |
      | CPlogin       | password |
      | agentlogin    | password |