Feature: SipTrunkPlus Manage Reseller
  Scenario: add a reseller. search, assert and delete
    Given I am logged in as a master user
    When I click on the create user tab and provide I should be able to create a valid reseller account
    And I should be able to search and delete the account from the database