package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;

/**
 * Created by RajeshG on 13/07/2017.
 */
public class NA172_WhiteLabel_Agent_Should_Distinguish_CPs_Tariffs_FreeMinutes_And_Packages_From_His_stepDefs {
   WebModel webModel =new WebModel();

    @Given("^CP has given me permissions and assigned me few tariff plans, freeMinute plans and packages$")
    public void cpHasGivenMePermissionsAndAssignedMeFewTariffPlansFreeMinutePlansAndPackages() throws InterruptedException, AWTException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","10","checkbox0");
        webModel.getConfigManagerPage().assignFreeMinutesPlanToAgent("Mobile 250 Free Mins (UK and Mob","checkbox0");
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().assignPackageToAgent("Winter Special Promotion","checkbox1");
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().issueTariffAndFreeMinutePermissionsToAgent("agent");
        webModel.getDashBoardPage().logOut();
    }

    @When("^I am logged in as an agent$")
    public void iAmLoggedInAsAnAgent() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();

    }

    @Then("^I should be able to distinguish from the ones CP has created$")
    public void iShouldBeAbleToDistinguishFromTheOnesCPHasCreated() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().distinguishCPCreatedTariff("Sell 2p NGCS AC (+60 sec)");
        webModel.getConfigManagerPage().accessFreeMinutesTab();
        webModel.getConfigManagerPage().distinguishCPCreatedFreeMinutes("Mobile 250 Free Mins (UK and Mob");
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().distinguishCPCreatedPackage("Winter Special Promotion");

    }
}
