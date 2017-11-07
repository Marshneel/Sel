#@SDSK
#
#
#Feature:  NA - 200 Mark Incident as Responded
#
#Scenario:Validation of Mark as Responded checkbox in Actions Modal
#    Given User has raised an open reach incident
#    And performed an action
#    When marked as responded and saved
#    Then should be able to see Mark as Responded checkbox in all the actions modal
#
#Scenario: Changing the incident status to final status and validating the Mark as Responded checkbox
#    Given User has raised an open reach incident
#    And performed an action
#    When changes the current status to some other status
#    Then should be able to see the Marked as Responded checkbox ticked automatically and should be disabled
#
#Scenario: Validate the badges based on incident being marked as responded
