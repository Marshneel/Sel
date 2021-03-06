@API
Feature: NA - 184 API smokePack
  Scenario: the user should be able to see a valid response code when he makes a valid GET request
    Given I make an API GET request call for sites
    Then I should be able to see the response 200

  Scenario: the user should be able to see a invalid response code when he makes aN invalid request code
    Given I make an invalid API GET request call for sites
    Then I should be able to see the response 404

  Scenario: the user should be able to POST a new site
    Given I make a valid POST request to create a site
    Then I should be able to see the response 201
    And when I delete the newly created site
    Then I should be able to see the response 204
    And I should be able to assert site deletion

  Scenario: the user should be able to update existing site details
    Given I make a valid PATCH request to update an existing site details
    Then I should be able to see the response 204
    And I should be able to assert the updated site details

