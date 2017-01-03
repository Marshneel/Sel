Feature: Agent login

#  @smokePack
#  Scenario: Login as an agent, create a business customer and verify the created customer from the company and site drop downs on create quote page
#    Given I am logged in as agent
#    And  Have created a new customer
#    When I access create Quote window
#    Then the newly created customer details should appear under the company and site drop downs
#
#  @smokePack1
#  Scenario Outline: Login as a CP, create a business customer, assign an agent and create a quote for the customer. when logged in as the agent the created quote should appear on the orders manager
#    Given I am logged in as an agent after the CP has created a quote for a "<customer_name>" assigned to me
#    And a quote been created for my "<customer_name>" by a CP
#    When I access orders manager
#    Then I should not see that particular quote
#    Examples:
#      | customer_name    |
#      | businessCustomer |