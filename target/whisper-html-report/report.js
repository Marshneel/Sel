$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/unionstreet/NxTier/com.unionstreet.NxTier.WLR3.feature/NA49_OrderServiceAutomation.feature");
formatter.feature({
  "line": 1,
  "name": "order service automation for agent, reseller and CP. includes CP only and mandatory fields under select service.",
  "description": "",
  "id": "order-service-automation-for-agent,-reseller-and-cp.-includes-cp-only-and-mandatory-fields-under-select-service.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5222041871,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Login as an agent, create a quote, add a service and verify the behaviour of CP only control",
  "description": "",
  "id": "order-service-automation-for-agent,-reseller-and-cp.-includes-cp-only-and-mandatory-fields-under-select-service.;login-as-an-agent,-create-a-quote,-add-a-service-and-verify-the-behaviour-of-cp-only-control",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@NA49b"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I am logged in as an agent",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Have created a quote",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I add a service from the quote details page",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "the control that is CP only should be invisible",
  "keyword": "Then "
});
formatter.match({
  "location": "NA39_BDD_Scenarios_Creation_Of_User_Agent_Reseller_permissions_stepdefs.iAmLoggedInAsAnAgent()"
});
formatter.result({
  "duration": 4164786656,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.haveCreatedAQuote()"
});
formatter.result({
  "duration": 19381736847,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.iAddAServiceFromTheQuoteDetailsPage()"
});
formatter.result({
  "duration": 10099166863,
  "status": "passed"
});
formatter.match({
  "location": "NA49_OrderServiceAutomation_stepDefs.theControlThatIsCPOnlyShouldBeInvisible()"
});
formatter.result({
  "duration": 1891483548,
  "status": "passed"
});
formatter.after({
  "duration": 549869154,
  "status": "passed"
});
});