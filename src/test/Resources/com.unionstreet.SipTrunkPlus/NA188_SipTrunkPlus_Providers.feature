@sipTrunkPlus
Feature: NA - 188 SipTrunkPlus Providers
  Scenario: user should be able to add a provider and assign/add them to a reseller
    Given I am logged in as a master user
    When I create a provider from the providers page under settings
    Then I should be able to assign and add them to the resellers
    And I should not be able to delete the provider unless I delete the same from the reseller

  Scenario: user should be able to un assign a provider from a reseller unless the provider is already added
    Given I am logged in as a master user and a reseller with provider added have already been created
    When I navigate to the additional page under the created reseller
    Then I should be not be able to un assign the assigned provider
    And When I delete the provider from the specific reseller then I should be able to un assign the reseller

  Scenario: user should not be able to delete a reseller who has provider added
    Given I am logged in as a master user and a reseller with provider added have already been created
    When I try to delete the reseller
    Then a validation message should be shown and the reseller should not be deleted

  Scenario: user should be able to edit the reseller side credentials for added provider
    Given I am logged in as a master user and a reseller with provider added have already been created
    When I navigate to the provider under reseller
    Then I should be able to successfully edit the reseller side credentails