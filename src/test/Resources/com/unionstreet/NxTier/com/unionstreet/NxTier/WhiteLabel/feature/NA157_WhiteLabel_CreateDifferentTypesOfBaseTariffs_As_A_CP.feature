@Morning
Feature: NA - 157 Create Different Types Of Base Tariffs (Blank, Copy and Based on) as a CP

  Scenario: Login in a CP and create the three types of base tariffs (blank, copy and based on)
    Given I am logged in as CP
    When I navigate to create tariff screen
    Then I should be able to create the 3 different types of CP tariffs