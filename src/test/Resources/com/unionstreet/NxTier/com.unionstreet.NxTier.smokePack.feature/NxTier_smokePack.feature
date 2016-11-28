Feature: Creating new business customer and assigning all the required inputs to generate an invoice bill

  @smokePack
  Scenario: Verify that login is successful with valid username and password
    Given I am on login page
    When I enter valid username and password
    Then Login is successful

  @smokePack
  Scenario Outline: : Login with invalid credentials
    Given I am on login page
    When I enter invalid "<userName>" and "<passWord>"
    Then The login should fail

    Examples:
      | userName | passWord |
      | john     | abcdef   |

  @smokePack
  Scenario: Creating a new Business Customer
    Given  I am logged in as an admin
    When I access add new business customer page
    And  Provide all the required info
    Then A new customer should be successfully created

#  @smokePack
#  Scenario: Creating a sub-site for a newly created customer
#    Given I am logged in as an admin
#    And I have added a new business customer
#    When I access Company Sites under the company menu and provide all the required info
#    Then A new site should appear under the respective company's menu

#  @smokePack1
#  Scenario: Adding invoice details and billing information to a newly created customer
#    Given I am logged in as an admin
#    And   I have added a new business customer
#    When  I access invoicing and billing details section under company menu and provide all required info
#    Then  Invoice details and billing details of that particular customer should be updated, respectively

  @smokePack
  Scenario: Adding pricing details, service charges (one off and recurring) and CLI to the newly created customer
    Given I am logged in as an admin
    And  I have added a new business customer
    When I access CLIs and service charges section under company menu and provide all required info
    Then CLIs and service charges of that particular customer should be updated, respectively


  @smokePack
  Scenario: Adding pricing details to a newly created customer
    Given I am logged in as an admin
    And   I have added a new business customer
    When I access pricing details under company menu and provide all required info
    Then Pricing details of that particular customer  should be updated

  @smokePack1
  Scenario Outline: Creating a Tariff under different Tariff Categories and verifying its presence under billing details of a business customer
    Given I am logged in as an admin
    And   I have added a new business customer
    When I create a tariff under one of "<tariff_Categories>"
    Then That particular tariff should be available for selection under that particular category under pricing details of that customer
    Examples:
      | tariff_Categories |
      | Mobile            |

  @smokePack
  Scenario Outline: Creating a tariff under different tariff types and its verification under search tariff
    Given I am logged in as an admin
    And   I have added a new business customer
    When  I create tariff under different "<tariff_types>"
    Then  that particular tariff should be available for selection in "<tariff_search>" under its tariff_type
    Examples:
      | tariff_types | tariff_search |
      | 0            | Sell          |

  @smokePack
  Scenario: Adding new service charge type and verifying if that is visible in the drop down in service charges
    Given I am logged in as an admin
    And   I have added a new business customer
    When I create a new service charge type
    Then I should be able to access it under service charge drop downs in one off and recurring charge types

@smokePack
  Scenario: Adding a new billing package under package manager and verifying it under pricing details
    Given I am logged in as an admin
    And   I have added a new business customer
    When  I create a new billing package under package manager
    Then I should be able to access it under package drop down in billing details

  @smokePack
  Scenario: Creating a new free minute plan, verify if its available under package and billing details
    Given I am logged in as an admin
    And   I have added a new business customer
    When I create a new free minutes plan with required details
    Then The plan should be available for selection under package and billing details


