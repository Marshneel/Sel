$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/unionstreet/NxTier/com.unionstreet.NxTier.WLR3.feature/WLR3_permissions.feature");
formatter.feature({
  "line": 1,
  "name": "WLR3_permissions",
  "description": "",
  "id": "wlr3-permissions",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6700599035,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Creating an agent permission group and assigning it to an agent",
  "description": "",
  "id": "wlr3-permissions;creating-an-agent-permission-group-and-assigning-it-to-an-agent",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@sprint"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "have added a new business customer with required contact type",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "have created a new agent permission group",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I wish to create agent contact with valid login credentials",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the agent permission group should be available for selection under drop down under agentUser creation",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I should be able to login with agent credentials",
  "keyword": "And "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedInAsAnAdmin()"
});
formatter.result({
  "duration": 4680560747,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.haveAddedANewBusinessCustomerWithRequiredContactType()"
});
formatter.result({
  "duration": 8029384561,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.haveCreatedANewAgentPermissionGroup()"
});
formatter.result({
  "duration": 23493745204,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iWishToCreateAgentContactWithValidLoginCredentials()"
});
formatter.result({
  "duration": 17055136390,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.theAgentPermissionGroupShouldBeAvailableForSelectionUnderDropDownUnderAgentUserCreation()"
});
formatter.result({
  "duration": 2776671181,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iShouldBeAbleToLoginWithAgentCredentials()"
});
formatter.result({
  "duration": 7149536414,
  "status": "passed"
});
formatter.after({
  "duration": 1652143385,
  "status": "passed"
});
formatter.before({
  "duration": 4820328269,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "creating a reseller with agent permission group",
  "description": "",
  "id": "wlr3-permissions;creating-a-reseller-with-agent-permission-group",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@sprint"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "have added a new business customer with required contact type",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "have created a new agent permission group",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I wish to create a business reseller contact with valid login credentials",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "the agent permission group should be available for selection under drop down under business reseller contact creation",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "I should be able to login with reseller credentials",
  "keyword": "And "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedInAsAnAdmin()"
});
formatter.result({
  "duration": 4653376231,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.haveAddedANewBusinessCustomerWithRequiredContactType()"
});
formatter.result({
  "duration": 8029544252,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.haveCreatedANewAgentPermissionGroup()"
});
formatter.result({
  "duration": 22814807928,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iWishToCreateABusinessResellerContactWithValidLoginCredentials()"
});
formatter.result({
  "duration": 13865514942,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.theAgentPermissionGroupShouldBeAvailableForSelectionUnderDropDownUnderBusinessResellerContactCreation()"
});
formatter.result({
  "duration": 2389373427,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iShouldBeAbleToLoginWithResellerCredentials()"
});
formatter.result({
  "duration": 4605559644,
  "status": "passed"
});
formatter.after({
  "duration": 628225129,
  "status": "passed"
});
formatter.before({
  "duration": 5167730868,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Creating a CP permission group and assigning it a CP",
  "description": "",
  "id": "wlr3-permissions;creating-a-cp-permission-group-and-assigning-it-a-cp",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@sprint"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Have created a new CP permission group under settings",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "I wish to create new CP under login users sub-menu",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "the CP permission should be available for selection under drop down during the CP creation",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "I should be able to login with CP credentials",
  "keyword": "And "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedInAsAnAdmin()"
});
formatter.result({
  "duration": 3854884809,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.haveCreatedANewCPPermissionGroupUnderSettings()"
});
formatter.result({
  "duration": 24382529679,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iWishToCreateNewCPUnderLoginUsersSubMenu()"
});
formatter.result({
  "duration": 11822906560,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.theCPPermissionShouldBeAvailableForSelectionUnderDropDownDuringTheCPCreation()"
});
formatter.result({
  "duration": 2765060867,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iShouldBeAbleToLoginWithCPCredentials()"
});
formatter.result({
  "duration": 5307073655,
  "status": "passed"
});
formatter.after({
  "duration": 515787323,
  "status": "passed"
});
formatter.before({
  "duration": 5437084058,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "creating an order quote by logged in as an agent and verifying all required fields are visible on the quote screen",
  "description": "",
  "id": "wlr3-permissions;creating-an-order-quote-by-logged-in-as-an-agent-and-verifying-all-required-fields-are-visible-on-the-quote-screen",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 31,
      "name": "@sprint"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "I am logged in as an agent",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "I  access agent create Quote tab",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "All required fields pertaining to an agent should be visible on the create quote window",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "Only the quotes created by me and the ones created for my company should be visible",
  "keyword": "And "
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iAmLoggedInAsAnAgent()"
});
formatter.result({
  "duration": 4046681547,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iAccessAgentCreateQuoteTab()"
});
formatter.result({
  "duration": 7122325636,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.allRequiredFieldsPertainingToAnAgentShouldBeVisibleOnTheCreateQuoteWindow()"
});
formatter.result({
  "duration": 5815085047,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.onlyTheQuotesCreatedByMeAndTheOnesCreatedForMyCompanyShouldBeVisible()"
});
formatter.result({
  "duration": 3289211866,
  "status": "passed"
});
formatter.after({
  "duration": 430405131,
  "status": "passed"
});
formatter.before({
  "duration": 4860653590,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "creating an order quote by logged in as a reseller and verifying all required fields are visible on the quote screen",
  "description": "",
  "id": "wlr3-permissions;creating-an-order-quote-by-logged-in-as-a-reseller-and-verifying-all-required-fields-are-visible-on-the-quote-screen",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 39,
      "name": "@sprint"
    }
  ]
});
formatter.step({
  "line": 41,
  "name": "I am logged in as a reseller",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I  access reseller create quote tab",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "All required fields pertaining to a reseller should be visible on the create quote window",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "Only the quotes created by me and the ones created for companies under my contact list should be visible",
  "keyword": "And "
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iAmLoggedInAsAReseller()"
});
formatter.result({
  "duration": 4217650902,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iAccessResellerCreateQuoteTab()"
});
formatter.result({
  "duration": 7481536881,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.allRequiredFieldsPertainingToAResellerShouldBeVisibleOnTheCreateQuoteWindow()"
});
formatter.result({
  "duration": 5718540821,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.onlyTheQuotesCreatedByMeAndTheOnesCreatedForCompaniesUnderMyContactListShouldBeVisible()"
});
formatter.result({
  "duration": 3272898681,
  "status": "passed"
});
formatter.after({
  "duration": 492073737,
  "status": "passed"
});
formatter.before({
  "duration": 4965953322,
  "status": "passed"
});
formatter.scenario({
  "line": 48,
  "name": "creating an order quote by logged in as a CP and verifying all required fields are visible on the quote screen",
  "description": "",
  "id": "wlr3-permissions;creating-an-order-quote-by-logged-in-as-a-cp-and-verifying-all-required-fields-are-visible-on-the-quote-screen",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 47,
      "name": "@sprint"
    }
  ]
});
formatter.step({
  "line": 49,
  "name": "I am logged in as a CP",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "I  access create Quote tab for CP",
  "keyword": "When "
});
formatter.step({
  "line": 51,
  "name": "All required fields pertaining to a CP should be visible on the create quote window",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "all the quotes including that of the resellers and agents should be visible",
  "keyword": "And "
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iAmLoggedInAsACP()"
});
formatter.result({
  "duration": 4451152820,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.iAccessCreateQuoteTabForCP()"
});
formatter.result({
  "duration": 7106470695,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.allRequiredFieldsPertainingToACPShouldBeVisibleOnTheCreateQuoteWindow()"
});
formatter.result({
  "duration": 6299961240,
  "status": "passed"
});
formatter.match({
  "location": "WLR3_permissions_stepdefs.allTheQuotesIncludingThatOfTheResellersAndAgentsShouldBeVisible()"
});
formatter.result({
  "duration": 3276188185,
  "status": "passed"
});
formatter.after({
  "duration": 473118264,
  "status": "passed"
});
});