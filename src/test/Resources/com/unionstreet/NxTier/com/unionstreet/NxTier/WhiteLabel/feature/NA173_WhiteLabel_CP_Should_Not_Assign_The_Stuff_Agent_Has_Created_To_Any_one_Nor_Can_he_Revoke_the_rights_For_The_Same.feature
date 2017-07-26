@WhiteLabel
Feature: NA - 173 WhiteLabel CP should not Assign the stuff agent has created to anyone not can he revoke the rights for the same
Scenario: CP should not be able to assign the agent created tariff, free minute and package to any one else apart from agent, and he should not be able to revoke the permissions
Given Agent has created a Tariff plan, FreeMinute plan and Package
And When I login as a CP
Then I should not be able to assign that particular plan to any one else and I should not be able to revoke the permissions of the creator
