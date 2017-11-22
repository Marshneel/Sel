@SDSK
    Feature: NA - 201 Update Incident Priority

    Scenario: Validating the presence of Priority Component
        Given I am logged in as AdamR
        When I navigate to second step of Log an Incident wizard
        Then I should be able to see the presence of Priority component

    Scenario:  Validate that clear badge is refreshed and a default action is created on changing the priority
        Given I am on View and Amend Details Page
        When changing the priority to other target clear badge should get refreshed
        And should validate that a default action is created on priority change

