$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com.unionstreet.NxTier_smokePack/NxTier_smokePack.feature");
formatter.feature({
  "line": 1,
  "name": "Creating new business customer and assigning all the required inputs to generate an invoice bill",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4471880586,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Verify that login is successful with valid username and password",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;verify-that-login-is-successful-with-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter valid username and password",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Login is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmOnLoginPage()"
});
formatter.result({
  "duration": 75798045,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iEnterValidUsernameAndPassword()"
});
formatter.result({
  "duration": 2529618814,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.LoginIsSuccessful()"
});
formatter.result({
  "duration": 395006367,
  "status": "passed"
});
formatter.after({
  "duration": 4314432399,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 8,
  "name": ": Login with invalid credentials",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;:-login-with-invalid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I am on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter invalid \"\u003cuserName\u003e\" and \"\u003cpassWord\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "The login should fail",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;:-login-with-invalid-credentials;",
  "rows": [
    {
      "cells": [
        "userName",
        "passWord"
      ],
      "line": 14,
      "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;:-login-with-invalid-credentials;;1"
    },
    {
      "cells": [
        "john",
        "abcdef"
      ],
      "line": 15,
      "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;:-login-with-invalid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3567756768,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": ": Login with invalid credentials",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;:-login-with-invalid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "I am on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter invalid \"john\" and \"abcdef\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "The login should fail",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmOnLoginPage()"
});
formatter.result({
  "duration": 5566527,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "john",
      "offset": 17
    },
    {
      "val": "abcdef",
      "offset": 28
    }
  ],
  "location": "NxTier_smokePack_stepDefs.iEnterInvalidAnd(String,String)"
});
formatter.result({
  "duration": 453342905,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.TheLoginShouldFail()"
});
formatter.result({
  "duration": 6204987,
  "status": "passed"
});
formatter.after({
  "duration": 704490171,
  "status": "passed"
});
formatter.before({
  "duration": 3889608284,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Creating a new Business Customer",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-new-business-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I am logged into the account as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I access add new business customer page",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Provide all the required info",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "A new customer should be successfully created",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedIntoTheAccountAsAdmin()"
});
formatter.result({
  "duration": 4065611964,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAccessAddNewBusinessCustomerPage()"
});
formatter.result({
  "duration": 718727982,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.provideAllTheRequiredInfo()"
});
formatter.result({
  "duration": 3595972478,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.aNewCustomerShouldBeSuccessfullyCreated()"
});
formatter.result({
  "duration": 1339866053,
  "status": "passed"
});
formatter.after({
  "duration": 697687175,
  "status": "passed"
});
formatter.before({
  "duration": 3871744986,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Adding invoice details and billing information to a newly created customer",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;adding-invoice-details-and-billing-information-to-a-newly-created-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "I am logged into the account as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "I access invoicing and billing details section under company menu and provide all required info",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Invoice details and billing details of that particular customer should be updated, respectively",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedIntoTheAccountAsAdmin()"
});
formatter.result({
  "duration": 4104588822,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 3971815382,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAccessInvoicingAndBillingDetailsSectionUnderCompanyMenuAndProvideAllRequiredInfo()"
});
formatter.result({
  "duration": 11501282355,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.invoiceDetailsAndBillingDetailsOfThatParticularCustomerShouldBeUpdatedRespectively()"
});
formatter.result({
  "duration": 283750994,
  "status": "passed"
});
formatter.after({
  "duration": 754067881,
  "status": "passed"
});
formatter.before({
  "duration": 3492913847,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Adding pricing details, service charges (one off and recurring) and CLI to the newly created customer",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;adding-pricing-details,-service-charges-(one-off-and-recurring)-and-cli-to-the-newly-created-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "I am logged into the account as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "I access CLIs and service charges section under company menu and provide all required info",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "CLIs and service charges of that particular customer should be updated, respectively",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedIntoTheAccountAsAdmin()"
});
formatter.result({
  "duration": 2784758945,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 4258432956,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAccessCLIsAndServiceChargesSectionUnderCompanyMenuAndProvideAllRequiredInfo()"
});
formatter.result({
  "duration": 16971688294,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.clisAndServiceChargesOfThatParticularCustomerShouldBeUpdatedRespectively()"
});
formatter.result({
  "duration": 2374255055,
  "status": "passed"
});
formatter.after({
  "duration": 760961137,
  "status": "passed"
});
formatter.before({
  "duration": 3853510082,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Adding orders to the customer account",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;adding-orders-to-the-customer-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "I am logged into the account as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "I access orders under company menu and provide all required details",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "I should be able to generate a quote",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedIntoTheAccountAsAdmin()"
});
formatter.result({
  "duration": 2380382158,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 4209040898,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAccessOrdersUnderCompanyMenuAndProvideAllRequiredDetails()"
});
formatter.result({
  "duration": 10769972331,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iShouldBeAbleToGenerateAQuote()"
});
formatter.result({
  "duration": 11591746567,
  "status": "passed"
});
formatter.after({
  "duration": 742524583,
  "status": "passed"
});
formatter.before({
  "duration": 3445897222,
  "status": "passed"
});
formatter.scenario({
  "line": 41,
  "name": "Adding pricing details to a newly created customer",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;adding-pricing-details-to-a-newly-created-customer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 42,
  "name": "I am logged into the account as admin",
  "keyword": "Given "
});
formatter.step({
  "line": 43,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "I access pricing details under company menu and provide all required info",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "Pricing details of that particular cusotmer  should be updated",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedIntoTheAccountAsAdmin()"
});
formatter.result({
  "duration": 2425894251,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 4897473871,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAccessPricingDetailsUnderCompanyMenuAndProvideAllRequiredInfo()"
});
formatter.result({
  "duration": 8609281127,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.pricingDetailsOfThatParticularCusotmerShouldBeUpdated()"
});
formatter.result({
  "duration": 206741837,
  "status": "passed"
});
formatter.after({
  "duration": 742203089,
  "status": "passed"
});
});