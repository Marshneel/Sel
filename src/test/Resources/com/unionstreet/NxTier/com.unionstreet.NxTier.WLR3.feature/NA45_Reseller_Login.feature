@E2ETests
Feature: NA45 - Reseller Login functionality

  Scenario: Login as a reseller, create a site and verify the created site from the site drop down on create quote page
    Given I am logged in as reseller
    And have created a new site for a company
    When I access create Quote tab and select the above company from the company dropdown
    Then The newly created site should appear under the site drop down