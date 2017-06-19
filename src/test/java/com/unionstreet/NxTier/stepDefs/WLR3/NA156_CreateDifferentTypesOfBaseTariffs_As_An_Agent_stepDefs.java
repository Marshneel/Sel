package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.awt.*;

/**
 * Created by RajeshG on 19/06/2017.
 */
public class NA156_CreateDifferentTypesOfBaseTariffs_As_An_Agent_stepDefs {
    WebModel webModel=new WebModel();

    @Given("^CP has give me permission to create and acess call tariffs$")
    public void cpHasGiveMePermissionToCreateAndAcessCallTariffs() throws InterruptedException, AWTException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","10");
        webModel.getDashBoardPage().logOut();
    }

    @And("^when I am logged in as agent$")
    public void whenIAmLoggedInAsAgent() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();

    }

    @Then("^I should be able to create the (\\d+) different types of base tariffs$")
    public void iShouldBeAbleToCreateTheDifferentTypesOfBaseTariffs(int arg0) throws InterruptedException, AWTException {
        webModel.getCreateTariffPage().createBlankTariff();
        webModel.getCommonMethods().search(webModel.getCreateTariffPage().RanTariffPlanName);
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().createTariffPlanBasedOnOtherPlan("1");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20","@value",true);
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","20");
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20","@value",true);
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().createTariffPlanBasedOnOtherPlan("2");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("40.0000","@basevalue",false);
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","10");
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20.0000","@basevalue",false);






    }



}
