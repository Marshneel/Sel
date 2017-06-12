Feature: NA - 151 Cut Copy Pasting URL

  Scenario: login as a CP and cut copy paste the URLs to verify security restrictions
    Given I am logged in as CP
    When I navigate to service desk and perform a valid search on the company
    Then Based on the status of the account and SLA, I should be able to or unable to navigate ahead via copying and pasting the URLs

