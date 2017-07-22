@Morning
@SDSK
Feature: Na - 159 SDSK Login Incident Caller Details

  Scenario: Login as a CP and navigate to caller details of incident wizard
    Given I am logged in as AdamR
    When I navigate to the caller details page of the incident wizard
    Then I should be able to check all the validations and populate caller details page