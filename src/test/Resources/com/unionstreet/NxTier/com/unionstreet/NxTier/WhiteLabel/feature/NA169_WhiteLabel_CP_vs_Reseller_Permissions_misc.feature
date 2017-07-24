@Morning
Feature: NA - 169 CP vs Agent view of sell, cost and baseLine prices
  Scenario: Login as a CP and check sell, cost and baseLine pricing of a serviceCharge
    Given I am logged in as CP
    When I navigate to create service charge page
    Then I should be able to see the cost, sell and baseline prices during the charge creation

  Scenario: agent will be able to see the pricing on the service charge page in his point of view
    Given CP has assigned a service charge to one of my customers
    When I am logged in as agent
    And navigate to that particular charge page
    Then I should be able to see the prices as an agent point of view