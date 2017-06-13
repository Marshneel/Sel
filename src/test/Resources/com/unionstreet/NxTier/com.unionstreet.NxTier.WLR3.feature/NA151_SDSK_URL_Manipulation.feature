Feature: NA - 151 NA151_SDSK_URL_Manipulation


  Scenario: login and perform URL manipulation tests
    Given I am logged in as a CP without access rights
    When I try to navigate to service desk page the access should be denied
    And when I am granted the service desk access to CP
    Then Based on the status of the account and SLA, I should be able to or unable to navigate ahead via pasting the URL for CP


    Given I am logged in as a agent without access rights
    When I try to navigate to service desk page the access should be denied
    And when I am granted the service desk access to agent
    Then Based on the status of the account and SLA, I should be able to or unable to navigate ahead via pasting the URL for agent

    Given I am logged in as a reseller without access rights
    When I try to navigate to service desk page the access should be denied
    And when I am granted the service desk access to reseller
    Then Based on the status of the account and SLA, I should be able to or unable to navigate ahead via pasting the URL for reseller