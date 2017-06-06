Feature: NA - 152 Agent Permission

  Scenario: An agent can only see but not edit the free minute and tariff plans issued by CP.
    Given CP has issued few tariff and free minute plans
    When  I am logged in as agent
    And navigate to see config manager page
    Then I should be able to see the tariff and free minute plans
    And I should not be able to edit them

#
#  Scenario: An agent can see and as well as edit the free minute plans created by him
#    Given I am logged in as agent
#    When I navigate to config manager
#    Then I should be able to make editable tariff and free minute plans
#
#  Scenario: An agent can see the business customer created by him
#    Given I am logged in as agent
#    And  Have created a new customer
#    When I navigate to contact manager page and search for the contact
#    Then I should be able to find it
#
#  Scenario: An agent can assign free minutes and tariff plans created by him to the customers under him
#    Given I am logged in as agent
#    When I create tariff and free minute plans
#    Then I should be able to assign them to my customers
#
#  Scenario: An agent can see and revoke tariff plans and free minutes assigned by CP to his customers, he cannot obviously reissue them
#    Given CP has issued tariff and free minute plans to customers assigned under me
#    When I am logged in as agent
#    And navigate to pricing details of that particular customer
#    Then I should be able to see and remove them
#    And I should not be able to see them once they are removed