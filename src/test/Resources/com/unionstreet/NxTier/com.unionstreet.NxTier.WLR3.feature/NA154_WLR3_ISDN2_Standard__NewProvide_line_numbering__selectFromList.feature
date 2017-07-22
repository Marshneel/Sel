@WLR3
Feature: NA - 154 ISDN2 standard new provide line numbering options: select from list

  Scenario: initiate a new provide service on ISDN2 standard and check select from list functionality under line numbering
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I initiate a new provide ISDN Standard line order
    And navigate to line numbering tab
    Then I should be able to check all the validations for select number from the list option for ISDN2 standard line