$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/unionstreet/NxTier/com.unionstreet.NxTier.smokePack.feature/NxTier_smokePack.feature");
formatter.feature({
  "line": 1,
  "name": "Creating new business customer and assigning all the required inputs to generate an invoice bill",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5714202441,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify that login is successful with valid username and password",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;verify-that-login-is-successful-with-valid-username-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@smokePack1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter valid username and password",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Login is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmOnLoginPage()"
});
formatter.result({
  "duration": 419048341,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iEnterValidUsernameAndPassword()"
});
formatter.result({
  "duration": 16603,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.LoginIsSuccessful()"
});
formatter.result({
  "duration": 21132,
  "status": "passed"
});
formatter.after({
  "duration": 311826824,
  "status": "passed"
});
});