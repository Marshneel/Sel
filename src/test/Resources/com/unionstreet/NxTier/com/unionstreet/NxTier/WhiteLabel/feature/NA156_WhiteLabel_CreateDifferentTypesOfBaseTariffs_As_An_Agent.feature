@Morning
Feature: NA - 156 Create Different Types Of Base Tariffs (Blank, Copy and Based on) as an agent

  Scenario: Login in as agent and create the three types of base tariffs (blank, copy and based on)
    Given CP has give me permission to create and acess call tariffs
    And when I am logged in as agent
    When I navigate to create tariff screen
    Then I should be able to create the 3 different types of agent tariffs

