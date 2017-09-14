Feature: NA - 191 API UI Tests

  Scenario: user should be able to POST a company and a contact through API and create a quote for the same through UI
    Given I am POST a company and a siteContact
    When I navigate to the orders manager page and access create quote popup
    Then I should be able to select the company and contact that was earlier created by API
    And I should be able to see the site contact auto populated by the contact posted by the API