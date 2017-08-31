@WLR3
Feature: NA94 - WLR3_Analogue_Add_Remove_Aux_line

  Scenario: Adding an extra line to existing multi-line
    Given I am logged in as CP
    And   I create a new business customer with a quote
    When I Initiate an add_remove aux order on the quote
    And Provide the required info to increase the number of lines
    Then I should be able to assert line increase and check the flow
    And make sure order is completed and ready for submission

    Scenario: Removing a line from existing multi-line and making sure that a CLI that is already a part of an
    order cannot be reused in a second order with in the same quote ID
      Given I am logged in as CP
      And   I create a new business customer with a quote
      When I Initiate an add_remove aux order on the quote
      And Provide the required info to decrease the number of lines
      Then I should be able to assert line decrease and check the flow
      And When I try to reuse the same CLI for a service within the sale quote
      Then An error with relevant text message should be thrown


