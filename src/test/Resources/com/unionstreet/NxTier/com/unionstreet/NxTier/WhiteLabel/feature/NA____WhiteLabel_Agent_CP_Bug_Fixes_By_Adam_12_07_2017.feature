Feature: NA - ___ WhiteLabel Agent and CP Bug fixes By Adam 12_07_2017

  Scenario:  CP should be able to distinguish between the Tariffs, Free minutes and Packages that Agent has created
  Given Agent has created a Tariff plan, FreeMinute plan and Package
  And When I login as a CP
  Then I should be able to distinguish from the ones agent has created

  Scenario: Agent should be able to distinguish between the tariffs plans, free minute plans and packages that he has created, from the ones CP has assigned to him
  Given CP has given me permissions and assigned me few tariff plans, freeMinute plans and packages
  When I am logged in as an agent
  Then I should be able to distinguish from the ones CP has created

  Scenario: CP should be not be able to assign the agent created tariff, free minute and package to any one else apart from agent, and he should not be able to revoke the permissions
  Given Agent has created a Tariff plan, FreeMinute plan and Package
  And When I login as a CP
  Then I should not be able to assign that particular plan to any one else and I should not be able to revoke the permissions of the creator

