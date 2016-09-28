$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/unionstreet/NxTier/com.unionstreet.NxTier.WLR3.feature/NA49_OrderServiceAutomation.feature");
formatter.feature({
  "line": 1,
  "name": "order service automation for agent, reseller and CP. includes CP only and mandatory fields under select service.",
  "description": "",
  "id": "order-service-automation-for-agent,-reseller-and-cp.-includes-cp-only-and-mandatory-fields-under-select-service.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5655278433,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Login as a reseller, create a quote, add a service without selecting the mandatory control and check the behaviour",
  "description": "",
  "id": "order-service-automation-for-agent,-reseller-and-cp.-includes-cp-only-and-mandatory-fields-under-select-service.;login-as-a-reseller,-create-a-quote,-add-a-service-without-selecting-the-mandatory-control-and-check-the-behaviour",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 39,
      "name": "@NA49f"
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
  "name": "Have created a quote",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "I access quote details and add a service without selecting the mandatory control",
  "keyword": "When "
});
formatter.step({
  "line": 44,
  "name": "The quote should become invalid",
  "keyword": "Then "
});
formatter.step({
  "line": 45,
  "name": "When I add the omitted control, the quote should become valid",
  "keyword": "And "
});
formatter.match({
  "location": "NA39_BDD_Scenarios_Creation_Of_User_Agent_Reseller_permissions_stepdefs.iAmLoggedInAsAReseller()"
});
formatter.result({
  "duration": 4265529293,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.haveCreatedAQuote()"
});
formatter.result({
  "duration": 20082338085,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.iAccessQuoteDetailsAndAddAServiceWithoutSelectingTheMandatoryControl()"
});
formatter.result({
  "duration": 13071004894,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.theQuoteShouldBecomeInvalid()"
});
formatter.result({
  "duration": 948340894,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.whenIAddTheOmittedControlTheQuoteShouldBecomeValid()"
});
formatter.result({
  "duration": 3402297369,
  "status": "passed"
});
formatter.after({
  "duration": 604490230,
  "status": "passed"
});
});