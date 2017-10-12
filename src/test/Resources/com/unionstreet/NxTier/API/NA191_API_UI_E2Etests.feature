@API
Feature: NA - 191 API UI Tests
  Scenario: user should be able to POST a company and a contact through API and create a quote for the same through UI
    Given I POST a company and a siteContact
    When I navigate to the orders manager page and access create quote popup
    Then I should be able to select the company and contact that was earlier created by API
    And I should be able to see the site contact auto populated by the contact posted by the API

  Scenario: user should be able to add a CLI to an existing site
    Given I am logged in as CP and there is a business customer already created
    When I POST a CLI for the site
    Then I should be able to verify the newly posted CLI

  Scenario: user should be able to assign a package with tariff and free minutes to a business customer
    Given I POST a company and a package under its site
    When I POST a tariff and free minute plan for that particular package
    Then I should be able to verify the package details on the UI

  Scenario: user should be able to a add a quote to site via API
    Given I POST a company and a siteContact
    When  I POST a quote for that particular company
    Then I should be able to confirm it on the UI
    And I should be able to delete the quote via API

  Scenario: user should be able to add and delete a service from an existing quote through API
    Given I POST a company and a siteContact
    And   I POST a quote for that particular company
    When I send a POST request to add a service to the quote
    Then I should be able to verify the added service on the UI
    And when I DELETE the service through API
    Then I should be able to confirm that on the UI

  Scenario: user should be able to POST a service charge under desired site
    Given I am logged in as CP
    When I POST a service charge under the site that is recently created
    Then I should be able to verify the new service charge under site menu

  Scenario: verify that a service charge POSTed should base all pricing calculations as per FrequencyTypeId (in CreateNewServiceCharge) rather then rc_frequency_type_ID (in recurringCharge_Types table)
    Given I am logged in as CP and a serviceCharge with unmatched frequency type has been POSTed
    When I perform a GET request on the charge details
    Then The pricing values should be based on the FrequencyTypeID from the request

#  Scenario: verify that an agent can only POST a service charge to the sites that he is agent for
#    Given I am logged as an agent and I POST a service charge to a company that is not under me
#    When I navigate go the service charge details of that particular site
#    Then The charge should be invisible
#    When I POST a service charge to company under me
#    Then I should be able to see under site menu