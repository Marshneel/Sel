Feature: Creating new business customer and assigning all the required inputs to generate an invoice bill

  Scenario: Verify that login is successful with valid username and password
    Given I am on login page
    When I enter valid username and password
    Then Login is successful

  Scenario Outline: : Login with invalid credentials
    Given I am on login page
    When I enter invalid "<userName>" and "<passWord>"
    Then The login should fail

    Examples:
      | userName | passWord |
      | john     | abcdef   |

  Scenario: Creating a new Business Customer
    Given  I am logged into the account as admin
    When I access add new business customer page
    And  Provide all the required info
    Then A new customer should be successfully created

  Scenario: Adding invoice details and billing information to a newly created customer
    Given I am logged into the account as admin
    And   I have added a new business customer
    When  I access invoicing and billing details section under company menu and provide all required info
    Then  Invoice details and billing details of that particular customer should be updated, respectively

  Scenario: Adding pricing details, service charges (one off and recurring) and CLI to the newly created customer
    Given I am logged into the account as admin
    And  I have added a new business customer
    When I access CLIs and service charges section under company menu and provide all required info
    Then CLIs and service charges of that particular customer should be updated, respectively

  Scenario: Adding orders to the customer account
    Given I am logged into the account as admin
    And I have added a new business customer
    When I access orders under company menu and provide all required details
    Then I should be able to generate a quote

  Scenario: Adding pricing details to a newly created customer
    Given I am logged into the account as admin
    And   I have added a new business customer
    When I access pricing details under company menu and provide all required info
    Then Pricing details of that particular cusotmer  should be updated