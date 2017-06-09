@E2ETests
Feature: NA49 - Order service automation for agent, reseller and CP

  Scenario: Login as a CP, create a quote, add a service and verify the behaviour of CP only control
    Given I am logged in as CP
    And Have created a quote
    When I add a service from the quote details page
    Then the control that is CP only should be visible

  Scenario: Login as an agent, create a quote, add a service and verify the behaviour of CP only control
    Given I am logged in as agent
    And Have created a quote
    When I add a service from the quote details page
    Then the control that is CP only should be invisible

  Scenario: Login as a reseller, create a quote, add a service and verify the behaviour of CP only control
    Given I am logged in as reseller
    And have created a new site for a company
    And Have created a quote for reseller
    When I add a service from the quote details page for reseller
    Then the control that is CP only should be invisible

  Scenario: Login as a CP, create a quote, add a service without selecting the mandatory control and check the behaviour
    Given I am logged in as CP
    And Have created a quote
    When I access quote details and add a service without selecting the mandatory control
    Then The quote should become invalid
    And When I add the omitted control, the quote should become valid

  Scenario: Login as an agent, create a quote, add a service without selecting the mandatory control and check the behaviour
    Given I am logged in as agent
    And Have created a quote
    When I access quote details and add a service without selecting the mandatory control for agent
    Then The quote should become invalid
    And When I add the omitted control, the quote should become valid

  Scenario: Login as a reseller, create a quote, add a service without selecting the mandatory control and check the behaviour
    Given I am logged in as reseller
    And have created a new site for a company
    And Have created a quote for reseller
    When I access quote details and add a service without selecting the mandatory control for reseller
    Then The quote should become invalid
    And When I add the omitted control, the quote should become valid
