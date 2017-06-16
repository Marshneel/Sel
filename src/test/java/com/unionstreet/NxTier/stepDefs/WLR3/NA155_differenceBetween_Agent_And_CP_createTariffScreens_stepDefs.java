package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 16/06/2017.
 */
public class NA155_differenceBetween_Agent_And_CP_createTariffScreens_stepDefs {

    WebModel webModel= new WebModel();

    @When("^I navigate to create tariff screen$")
    public void iNavigateToCreateTariffScreen() {
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
    }

    @Then("^I should be able to compare the differences with that of agent create tariff screen$")
    public void iShouldBeAbleToCompareTheDifferencesWithThatOfAgentCreateTariffScreen() throws InterruptedException {
        webModel.getConfigManagerPage().validationsForNewTariffScreenByCP();


    }

    @Then("^I should be able to compare the differences with that of CP create tariff screen$")
    public void iShouldBeAbleToCompareTheDifferencesWithThatOfCPCreateTariffScreen() throws InterruptedException {
        webModel.getConfigManagerPage().validationsForNewTariffScreenByAgent();
    }
}
