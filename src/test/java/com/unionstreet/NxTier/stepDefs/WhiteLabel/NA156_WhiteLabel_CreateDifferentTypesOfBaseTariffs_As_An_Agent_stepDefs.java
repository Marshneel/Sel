package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.awt.*;

/**
 * Created by RajeshG on 19/06/2017.
 */
public class NA156_WhiteLabel_CreateDifferentTypesOfBaseTariffs_As_An_Agent_stepDefs {
    WebModel webModel=new WebModel();

    @Given("^CP has give me permission to create and acess call tariffs$")
    public void cpHasGiveMePermissionToCreateAndAcessCallTariffs() throws InterruptedException, AWTException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","10","checkbox0");
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().issueTariffAndFreeMinutePermissionsToAgent("agent");
        webModel.getDashBoardPage().logOut();
    }

    @And("^when I am logged in as agent$")
    public void whenIAmLoggedInAsAgent() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();

    }

    @Then("^I should be able to create the (\\d+) different types of agent tariffs$")
    public void iShouldBeAbleToCreateTheDifferentTypesOfAgentTariffs(int arg0) throws InterruptedException, AWTException {
        webModel.getCreateTariffPage().createBlankTariff("3","1","0",false,true);
        webModel.getCommonMethods().search(webModel.getCreateTariffPage().RanTariffPlanName);
        webModel.getCreateTariffPage().assertCreatedTariff("Sell","Fixed Line");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("11","@value",true);
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().createTariffPlanBasedOnOtherPlan("3","2","1","0","Sell 2p NGCS AC (+60 sec)");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20","@value",true);
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","20","checkbox0");
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20","@value",true);
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().createTariffPlanBasedOnOtherPlan("3","2","2","0","Sell 2p NGCS AC (+60 sec)");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("40.0000","@basevalue",false);
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","10","checkbox0");
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20.0000","@basevalue",false);
    }
}
