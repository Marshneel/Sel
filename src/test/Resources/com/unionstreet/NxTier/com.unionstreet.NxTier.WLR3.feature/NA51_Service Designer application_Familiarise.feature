@E2ETests
Feature: Verify customer and internal fields by logging as CP, agent and reseller

  Scenario: Verify that the customer and internal tabs are present and accessible under add/view notes under edit order page
    Given I am logged in as CP
    When I access add_view notes on edit order page
    Then customer and internal tabs should be present and accessible

  Scenario: Verify the customer and internal tabs are absent under add/view notes under edit order page
    Given I am logged in as reseller
    And have created a new site for a company
    And Have created a quote for reseller
    When I access add_view notes on edit order page for reseller
    Then customer and internal tabs should be absent

  Scenario: Verify the customer and internal tabs are absent under add/view notes under edit order page
    Given I am logged in as agent
    When I access add_view notes on edit order page
    Then customer and internal tabs should be absent

  Scenario: Assert that an assigned service is unavailable to agent and vice versa
    Given I am logged in as agent and there is a service unassigned to me
    When I access the services page
    Then I should not be able to see that particular service
    And I should be able to see the service once CP assigns it to me