@sip
Feature: SipTrunkPlus smoke pack
  Scenario: create a reseller, search and delete the account
    Given I am logged in as a master user
    When I click on the create user tab and provide I should be able to create a valid reseller account
    And I should be able to search and find the created account

    Scenario: create a client for the reseller, search and delete the account
      Given I am logged in as a master user and have created a reseller
      When I click add client and provide all the valid info
      Then I should be able to create a client for that particular reseller
      And I should be able to search and delete the newly created clients account

