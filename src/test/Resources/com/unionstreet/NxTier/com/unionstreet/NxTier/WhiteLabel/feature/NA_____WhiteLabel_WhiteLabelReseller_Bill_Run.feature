Feature: NA - ___ WhiteLabel Reseller Bill run
  Scenario: whiteLabelReseller should not be able to see any other bill runs apart from the ones CP has created for him
    Given I am logged in as CP
    And have created a whiteLabelReseller with a bill run
    When I navigate to the invoicing details page and access the bill run drop down
    Then I should be able to see the bill run that