@Night
Feature: NA107 - ISDN30_Amend
  Scenario: amend a submitted ISDN30 new provide order
    Given I am logged in as CP
    And  there is an ISDN30 new provide order already submitted and in processing stage
    When I initiate an amend on the order
    Then I should be able to assert edit tabs