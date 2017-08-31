Feature: NA - 184 API Add and Delete Customer
  Scenario: Add a business customer and assert creation
    Given I access add new business customer
    Then I should be able to see response 200
    And I should be able to assert the creation