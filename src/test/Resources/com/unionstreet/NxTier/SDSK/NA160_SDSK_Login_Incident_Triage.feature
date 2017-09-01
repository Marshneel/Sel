@SDSK
Feature: NA - 160 SDSK Login Incident Triage

  Scenario: Login as a CP and navigate to triage of incident wizard
    Given I am logged in as AdamR
    When I navigate to the triage page of the incident wizard
    Then I should be able to check all the validations and populate it