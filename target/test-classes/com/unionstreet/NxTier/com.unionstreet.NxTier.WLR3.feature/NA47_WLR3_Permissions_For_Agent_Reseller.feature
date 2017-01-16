@E2ETests
Feature: Granting and Revoking WLR3 permissions for Agent and Reseller

  Scenario: CP revokes the WLR3 order permissions for an agent so that the WLR3 orders are hidden from the agent when he logs in and vice versa
    Given CP has revoked my WLR order permissions
    When I am logged in as agent
    Then I should not be able to see and edit them
    And the orders are visible and editable once the CP issues the orders back agent rights
  @reseller
  Scenario: CP revokes the WLR3 order permissions for a reseller so that the WLR3 orders are hidden from the reseller when he logs in and vice versa
    Given CP has revoked my WLR order permissions
    When I am logged in as reseller
    Then I should not be able to see and edit them
    And the orders are visible and editable once the CP issues the orders back reseller rights