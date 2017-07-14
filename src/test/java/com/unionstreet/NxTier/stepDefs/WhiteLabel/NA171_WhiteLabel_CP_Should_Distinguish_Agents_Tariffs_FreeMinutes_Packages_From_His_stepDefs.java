package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by RajeshG on 13/07/2017.
 */
public class NA171_WhiteLabel_CP_Should_Distinguish_Agents_Tariffs_FreeMinutes_Packages_From_His_stepDefs {
   WebModel webModel=new WebModel();

    @Given("^Agent has created a Tariff plan, FreeMinute plan and Package$")
    public void agentHasCreatedATariffPlanFreeMinutePlanAndPackage() throws InterruptedException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().issueTariffAndFreeMinutePermissionsToAgent("agent");
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().addTariffPlan();
        webModel.getConfigManagerPage().addFreeMinutesPlan();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().clickAdd();
        webModel.getConfigManagerPage().createPackage("1",webModel.getCreateTariffPage().RanTariffPlanName,true,true);
        webModel.getConfigManagerPage().saveAndAssertThePackage("[@disabled='True']");

    }

    @And("^When I login as a CP$")
    public void whenILoginAsACP() throws InterruptedException {
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();

    }

    @Then("^I should be able to distinguish from the ones agent has created$")
    public void iShouldBeAbleToDistinguishFromTheOnesAgentHasCreated() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().distinguishAgentCreatedTariffs();
        webModel.getConfigManagerPage().accessFreeMinutesTab();
        webModel.getConfigManagerPage().distinguishAgentCreatedFreeMinutes();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().distinguishAgentCreatedPackages();







    }
}
