@SDSK
Feature: NA - 198 Display Company Name And Account
    
Scenario: Validate that company name and site name are displayed when company and site name are not same
    Given I am logged in as AdamR
    When I raise an incident and submit it
    Then I should be able to see Incident View and Amend Details Page
    And I should be able to validate that company and site name are displayed when company and site name are not same

Scenario: Validate that company name and short Name are displayed when company and site name are same
     Given I am logged in as AdamR
     When I raise an open reach incident and submit it
     Then I should be able to see Incident View and Amend Details Page
     And I should be able to validate that company and short name are displayed when company and site name are same

Scenario: Validate that only company name should be displayed when company and site name are the same and short name is either null or empty
      Given I am logged in as AdamR
      When I raise a incident and submit it
      Then I should be able to see Incident View and Amend Details Page
      And I should be able to validate that only company name should be displayed when company and site name are same and short name is null or empty

