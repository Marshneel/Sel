$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/unionstreet/NxTier/com.unionstreet.NxTier.smokePack.feature/NxTier_smokePack.feature");
formatter.feature({
  "line": 1,
  "name": "Creating new business customer and assigning all the required inputs to generate an invoice bill",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 66,
  "name": "Creating a tariff under different tariff types and its verification under search tariff",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-types-and-its-verification-under-search-tariff",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 65,
      "name": "@smokePack1"
    }
  ]
});
formatter.step({
  "line": 67,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 68,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 69,
  "name": "I create tariff under different \"\u003ctariff_types\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "that particular tariff should be available for selection in \"\u003ctariff_search\u003e\" under its tariff_type",
  "keyword": "Then "
});
formatter.examples({
  "line": 71,
  "name": "",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-types-and-its-verification-under-search-tariff;",
  "rows": [
    {
      "cells": [
        "tariff_types",
        "tariff_search"
      ],
      "line": 72,
      "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-types-and-its-verification-under-search-tariff;;1"
    },
    {
      "cells": [
        "0",
        "Sell"
      ],
      "line": 73,
      "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-types-and-its-verification-under-search-tariff;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5432772284,
  "status": "passed"
});
formatter.scenario({
  "line": 73,
  "name": "Creating a tariff under different tariff types and its verification under search tariff",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-types-and-its-verification-under-search-tariff;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 65,
      "name": "@smokePack1"
    }
  ]
});
formatter.step({
  "line": 67,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 68,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 69,
  "name": "I create tariff under different \"0\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 70,
  "name": "that particular tariff should be available for selection in \"Sell\" under its tariff_type",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedInAsAnAdmin()"
});
formatter.result({
  "duration": 3784003122,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 7191118978,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 33
    }
  ],
  "location": "NxTier_smokePack_stepDefs.iCreateTariffUnderDifferent(String)"
});
formatter.result({
  "duration": 5339064177,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sell",
      "offset": 61
    }
  ],
  "location": "NxTier_smokePack_stepDefs.thatParticularTariffShouldBeAvailableForSelectionInUnderItsTariff_type(String)"
});
formatter.result({
  "duration": 3079186237,
  "status": "passed"
});
formatter.after({
  "duration": 575942468,
  "status": "passed"
});
});