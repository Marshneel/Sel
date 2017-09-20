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