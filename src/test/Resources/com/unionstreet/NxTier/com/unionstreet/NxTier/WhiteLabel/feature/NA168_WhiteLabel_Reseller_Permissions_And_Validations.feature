@Morning
Feature: NA - 168 Reseller permissions and validations
  Scenario: login as a reseller and check relevant permissions and validations
    Given I am logged in as reseller
    When I create a site
    Then that site should automatically become the non-billing site
    And Reseller should not be able to see cost and baseLine prices in service charges under siteMenu