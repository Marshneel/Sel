@WhiteLabel
Feature: NA - 168 Reseller's view of sell, cost and baseLine prices and other validations
  Scenario: login as a reseller and check the sell/cost and baseLine in reseller point of view
    Given CP has added a service charge to one of my sites
    When I login as a reseller and access that particular charge
    Then I should see the charges at reseller's point of view


Scenario: Any secondary sites created by reseller should automatically become non-billing sites
  Given I am logged in as reseller
  When i create a site
  Then that site should automatically become the non-billing site