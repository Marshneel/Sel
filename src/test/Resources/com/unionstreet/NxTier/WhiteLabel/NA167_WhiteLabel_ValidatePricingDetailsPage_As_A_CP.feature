@E2ETests
Feature: NA - 167 WhiteLabel Validating pricing details page as a CP

  Scenario: login as a CP and validate the pricing details page by adding a package
    Given I am logged in as CP
    When I create a customer and navigate to pricing details
    And select a package from the dropdown
    Then I should be able to perform extensive validations on pricing details page