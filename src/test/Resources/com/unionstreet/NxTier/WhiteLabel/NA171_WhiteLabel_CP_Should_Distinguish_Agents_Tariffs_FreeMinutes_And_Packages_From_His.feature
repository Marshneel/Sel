@WhiteLabel
Feature: NA - 171 WhiteLabel CP Should Distinguish Agents Tariffs, FreeMinutes and Packages from his
  Scenario:  CP should be able to distinguish between the Tariffs, Free minutes and Packages that Agent has created
  Given Agent has created a Tariff plan, FreeMinute plan and Package
  And When I login as a CP
  Then I should be able to distinguish from the ones agent has created



