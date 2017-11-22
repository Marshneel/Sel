@SDSK


Feature:  NA - 200 Mark Incident as Responded

Scenario: Validating a default action is created once Mark as Responded Checkbox is ticked for an action
        Given User has raised an open reach incident
        And performed an action
        When marked as responded checkbox is ticked
        Then should be able to assert that a default action Responded has been created
        And should be able to validate the Marked as Responded checkbox is not present once responded

Scenario: Changing the incident status to final status and validating the Mark as Responded checkbox
       Given User has raised an open reach incident
       And performed an action
       Then should be able to validate that mark as responded checkbox is unchecked
       When changes the current status to some other status
       Then should be able to validate the Marked as Responded checkbox is not present once status is changed to final status
