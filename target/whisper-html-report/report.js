$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/unionstreet/NxTier/com.unionstreet.NxTier.smokePack.feature/NxTier_smokePack.feature");
formatter.feature({
  "line": 1,
  "name": "Creating new business customer and assigning all the required inputs to generate an invoice bill",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 56,
  "name": "Creating a Tariff under different Tariff Categories and verifying its presence under billing details of a business customer",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-categories-and-verifying-its-presence-under-billing-details-of-a-business-customer",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 55,
      "name": "@smokePack1"
    }
  ]
});
formatter.step({
  "line": 57,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 58,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I create a tariff under one of \"\u003ctariff_Categories\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "That particular tariff should be available for selection under that particular category under pricing details of that customer",
  "keyword": "Then "
});
formatter.examples({
  "line": 61,
  "name": "",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-categories-and-verifying-its-presence-under-billing-details-of-a-business-customer;",
  "rows": [
    {
      "cells": [
        "tariff_Categories"
      ],
      "line": 62,
      "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-categories-and-verifying-its-presence-under-billing-details-of-a-business-customer;;1"
    },
    {
      "cells": [
        "Mobile"
      ],
      "line": 63,
      "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-categories-and-verifying-its-presence-under-billing-details-of-a-business-customer;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7869597885,
  "status": "passed"
});
formatter.scenario({
  "line": 63,
  "name": "Creating a Tariff under different Tariff Categories and verifying its presence under billing details of a business customer",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;creating-a-tariff-under-different-tariff-categories-and-verifying-its-presence-under-billing-details-of-a-business-customer;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 55,
      "name": "@smokePack1"
    }
  ]
});
formatter.step({
  "line": 57,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 58,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I create a tariff under one of \"Mobile\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 60,
  "name": "That particular tariff should be available for selection under that particular category under pricing details of that customer",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedInAsAnAdmin()"
});
formatter.result({
  "duration": 3986761307,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 7089156739,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mobile",
      "offset": 32
    }
  ],
  "location": "NxTier_smokePack_stepDefs.iCreateATariffUnderOneOf(String)"
});
formatter.result({
  "duration": 6194504199,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.thatParticularTariffShouldBeAvailableForSelectionUnderThatParticularCategoryUnderPricingDetailsOfThatCustomer()"
});
formatter.result({
  "duration": 12782827764,
  "status": "passed"
});
formatter.after({
  "duration": 1243656868,
  "status": "passed"
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
  "duration": 5345217316,
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
  "duration": 4961271651,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 7271552461,
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
  "duration": 6483096855,
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
  "duration": 2963064180,
  "status": "passed"
});
formatter.after({
  "duration": 736617161,
  "status": "passed"
});
formatter.before({
  "duration": 5179191629,
  "status": "passed"
});
formatter.scenario({
  "line": 76,
  "name": "Adding new service charge type and verifying if that is visible in the drop down in service charges",
  "description": "",
  "id": "creating-new-business-customer-and-assigning-all-the-required-inputs-to-generate-an-invoice-bill;adding-new-service-charge-type-and-verifying-if-that-is-visible-in-the-drop-down-in-service-charges",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 75,
      "name": "@smokePack1"
    }
  ]
});
formatter.step({
  "line": 77,
  "name": "I am logged in as an admin",
  "keyword": "Given "
});
formatter.step({
  "line": 78,
  "name": "I have added a new business customer",
  "keyword": "And "
});
formatter.step({
  "line": 79,
  "name": "I create a new service charge type",
  "keyword": "When "
});
formatter.step({
  "line": 80,
  "name": "I should be able to access it under service charge drop downs in one off and recurring charge types",
  "keyword": "Then "
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iAmLoggedInAsAnAdmin()"
});
formatter.result({
  "duration": 4171246903,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iHaveAddedANewBusinessCustomer()"
});
formatter.result({
  "duration": 7107445486,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iCreateANewServiceChargeType()"
});
formatter.result({
  "duration": 6756840017,
  "status": "passed"
});
formatter.match({
  "location": "NxTier_smokePack_stepDefs.iShouldBeAbleToAccessItUnderServiceChargeDropDownsInOneOffAndRecurringChargeTypes()"
});
formatter.result({
  "duration": 13052645052,
  "status": "passed"
});
formatter.after({
  "duration": 509159769,
  "status": "passed"
});
});