@E2ETests
Feature: NA97 - Test script to verify the steps involved in change of address

  Scenario: scenario to verify the retain line number option availability when postCode that is within the same exchange is used
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And I initiate a change of address service
    When I provide a postCode that is within the same exchange under installation address
    Then Retain option availability is displayed

  Scenario: scenario to verify the retain line number option availability when postCode that is outside the exchange is used
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And I initiate a change of address service
    When  Provide a postCode that is outside the exchange
    Then Message stating retain option unavailability should be displayed
    And when i navigate forward and provide all required information
    Then I should be able to complete the order and see a green tick
@test
    Scenario: scenario to verify the absence of address match validation message when a gold address is associated with the site
      Given I am logged in as CP
      And   I create a new business customer with a quote
      And   I insert an addressKey and Gold address value under the site
     When I initiate a change of address service
      Then The validation message is absent under the installation address panel
