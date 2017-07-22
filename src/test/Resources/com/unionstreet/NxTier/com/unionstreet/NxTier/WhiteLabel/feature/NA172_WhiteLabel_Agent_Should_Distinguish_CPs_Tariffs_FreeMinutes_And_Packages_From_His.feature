@Morning
Feature: NA - 172 WhiteLabel Agent Should Distinguish between the tariffs, freeMinutes and packages that he has created from the ones CP has assigned
Scenario: Agent should be able to distinguish between the tariffs plans, free minute plans and packages that he has created, from the ones CP has assigned to him
Given CP has given me permissions and assigned me few tariff plans, freeMinute plans and packages
When I am logged in as an agent
Then I should be able to distinguish from the ones CP has created
