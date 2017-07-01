@E2ETests
Feature: NA - 168 Reseller permissions and validations
  Scenario: login as a reseller and check relevant permissions and validations
    Given I am logged in as reseller
    When I create a site
    Then that site should automatically become the non-billing site