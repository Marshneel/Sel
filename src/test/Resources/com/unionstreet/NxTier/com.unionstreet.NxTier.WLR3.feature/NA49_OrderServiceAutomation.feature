Feature: order service automation for agent, reseller and CP. includes CP only and mandatory fields under select service.
@NA49a
Scenario: Login as a CP, create a quote, add a service and verify the behaviour of CP only control
Given I am logged in as a CP
And Have created a quote
When I add a service from the quote details page
Then the control that is CP only should be visible

@NA49b
Scenario: Login as an agent, create a quote, add a service and verify the behaviour of CP only control
Given I am logged in as an agent
And Have created a quote
When I add a service from the quote details page
Then the control that is CP only should be invisible

@NA49c
Scenario: Login as a reseller, create a quote, add a service and verify the behaviour of CP only control
Given I am logged in as a reseller
And Have created a quote
When I add a service from the quote details page
Then the control that is CP only should be invisible

@NA49d
Scenario: Login as a CP, create a quote, add a service without selecting the mandatory control and check the behaviour
Given I am logged in as a CP
And Have created a quote
When I access quote details and add a service without selecting the mandatory control
Then The quote should become invalid
And When I add the omitted control, the quote should become valid

@NA49e
Scenario: Login as an agent, create a quote, add a service without selecting the mandatory control and check the behaviour
Given I am logged in as an agent
And Have created a quote
When I access quote details and add a service without selecting the mandatory control
Then The quote should become invalid
And When I add the omitted control, the quote should become valid

@NA49f
Scenario: Login as a reseller, create a quote, add a service without selecting the mandatory control and check the behaviour
Given I am logged in as a reseller
And Have created a quote
When I access quote details and add a service without selecting the mandatory control
Then The quote should become invalid
And When I add the omitted control, the quote should become valid
