@SDSK
Feature: NA - 187 SDSK Search An Incident

 Scenario Outline: As a user I should be able to search for the created incidents
   Given I am logged in as "<userName>" and "<passWord>"
    When I navigate to the browse incident page
    Then I should be able to search by for the incidents "<by>" and perform all the validations
    Examples:
      | userName |passWord| by |
      | Adamr    |password| Router seems to be damaged|
      | agentAdam|abcdef  | Router seems to be damaged|

    Scenario: The user should be able to set the number of rows to display and pagination of the searched data
      Given I am logged in as AdamR and navigate to the branchURL
      When I navigate to the browse incident page
      Then I should be able to validate the data view