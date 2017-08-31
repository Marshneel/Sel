@WLR3
Feature: NA120 - WLR3_ISDN2_Logic_For_Point_To_Point_And_Point_To_MultiPoint

  Scenario: testing logic for ISDN2 Standard: point-to-multiPoint
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And I initiate a new provide ISDN Standard line order
    When I provide all the required info and access the line information on the edit order page
    Then I should be able to check all point_to_multipoint validations

  Scenario: testing logic for ISDN2 System: point-to-point
    Given I am logged in as CP
    And   I create a new business customer with a quote
    And I initiate a new provide ISDN System line order
    When I provide all the required info and access the line information on the edit order page
    Then I should be able to check all point_to_Point validations