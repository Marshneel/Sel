@WhiteLabel
Feature: NA - 170 Editing a Service Charge under Site Menu
  Scenario: create and edit a service charge as a CP
    Given I am logged in as CP
    When I search for a business customer and navigate to add service charge page
    Then I should be able to perform the required validations and create new service charge for that customer