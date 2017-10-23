
Feature:NA185_SDSK Appointment Selection And Reservation Functionality

  Scenario Outline: Validating The Appointment Selection and Reservation Functionality
    Given I am logged in as AdamR
    When I am on ServiceDesk Ticket Details Page to Select  "<slotTime>" and Reserve an Appointment
    Then I should be able to Reserve the Selected  "<slotTime>"

    Examples:
      |   slotTime    |
      |  7am - 8am    |


  Scenario Outline: Validating the Appointment Cancellation Functionality
    Given I am logged in as AdamR
    When I am on ServiceDesk Ticket Details Page to Cancel an Appointment
    Then I should not be able to Reserve the "<slotTime>" Appointment

    Examples:
      |     slotTime   |
      |     6pm - 9pm  |