package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NA155_WhiteLabel_differenceBetween_Agent_And_CP_createTariffScreens_stepDefs {
    WebModel webModel=new WebModel();


    @When("^I navigate to create tariff screen$")
    public void iNavigateToCreateTariffScreen() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
    }

    @Then("^I should be able to compare the differences with that of agent create tariff screen$")
    public void iShouldBeAbleToCompareTheDifferencesWithThatOfAgentCreateTariffScreen() throws InterruptedException {
        webModel.getCreateTariffPage().validationsForNewTariffScreenByCP();


    }

    @Then("^I should be able to compare the differences with that of CP create tariff screen$")
    public void iShouldBeAbleToCompareTheDifferencesWithThatOfCPCreateTariffScreen() throws InterruptedException {
        webModel.getCreateTariffPage().validationsForNewTariffScreenByAgent();
    }

}
